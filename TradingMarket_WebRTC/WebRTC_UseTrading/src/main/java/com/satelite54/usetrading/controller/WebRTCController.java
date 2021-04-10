package com.satelite54.usetrading.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.satelite54.RTC.model.ChatMessage;
import com.satelite54.RTC.model.RTC;
import com.satelite54.RTC.model.Room;

@Controller
@RequestMapping(value = "/webrtc")
public class WebRTCController {
	
    @Autowired
    private SimpMessagingTemplate smt;
	
    private HashMap<Integer, Room> rooms = new HashMap<>();

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private final static String WSprefix = "ws";

    @Autowired
	public WebRTCController(SimpMessagingTemplate smt) {
    	this.smt = smt;
	}
    
    @RequestMapping(value = "/createRoom", method = RequestMethod.POST)
    public String create(@RequestParam(name="roomId") Integer roomId){
        if (!rooms.containsKey(roomId)) {
            logger.log(Level.INFO, "[ROOM] Room with id " + roomId + " has been created");
            rooms.put(roomId, new Room());
            return "redirect:/webrtc/r/" + roomId;
        }
        else {
            System.out.println("USER DOUN");
            return "hello";
        }
    }
    
    @RequestMapping(value = "/r/{roomId}")
    public ModelAndView room(@PathVariable Integer roomId) {
        JSONObject offer = new JSONObject();
        JSONObject answer = new JSONObject();
        Room room = rooms.get(roomId);
        Integer userId = room.getUsersCount();
        if (!room.empty()) {
            offer = room.getOffer();
            if (room.hasAnswer()) {
                answer = room.getAnswer();
            }
        }
        return new ModelAndView("/webrtc/room")
            .addObject("offer", offer)
            .addObject("answer", answer)
            .addObject("userId", userId)
            .addObject("roomId", roomId);
    }
    @ResponseBody
    @RequestMapping(value = "/sendOffer/{roomId}")
    public String sendOffer(HttpServletRequest request,
                            @PathVariable Integer roomId,
                            @RequestBody String offer) {
        logger.log(Level.INFO, "[OFFER] " + "Get offer from " + getIP(request) + " " + offer);

        RTC rtc = new RTC().setOffer(offer);
        rooms.get(roomId)
                .add(rtc);

        return "/" + roomId + "/1";
    }

    @ResponseBody
    @RequestMapping(value = "/sendAnswer/{roomId}")
    public String sendAnswer(HttpServletRequest request,
                             @PathVariable Integer roomId,
                             @RequestBody String answer) {
        logger.log(Level.INFO, "[ANSWER] " + "Get answer from " + getIP(request) + " " + answer);

        RTC rtc = new RTC().setAnswer(answer);
        rooms.get(roomId)
                .add(rtc);

        smt.convertAndSend(
                urlGenerator(WSprefix, "answer", roomId),
                answer
        );

        return "/" + roomId + "/2";
    }

    @ResponseBody
    @RequestMapping(value = "/ice/{roomId}/{id}")
    public String iceCandidate(@PathVariable Integer roomId,
                                @PathVariable Integer id,
                                @RequestBody String candidate) {
        logger.log(Level.INFO, "[CANDIDATE] " + "Candidate from " + roomId + "/" + id +  " " + candidate);

        List<RTC> connections = rooms.get(roomId).getConnections();
        for (int i = 0; i < connections.size(); i++) {
            if (i != id) {
                smt.convertAndSend(
                        urlGenerator(WSprefix, roomId, i),
                        candidate
                );
            }
        }

        return candidate;
    }
    
    /*Chat logic*/
    @MessageMapping("/chat/sendMessage")
    public void sendMassage(@Payload ChatMessage message) throws Exception{
        System.out.println(message.getMessage());
        smt.convertAndSend(
                urlGenerator(WSprefix, message.getRoomName()),
                message
        );
    }

    private Integer getRoomId(HttpServletRequest request) {
        String referer = request.getHeader("referer");
        return Integer.parseInt(
            referer.substring(referer.lastIndexOf('/') + 1)
        );
    }

    private String getIP(HttpServletRequest request) throws RuntimeException {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            return request.getRemoteAddr();
        }
        else {
            throw new RuntimeException("YA HASHE HZ CHE ZA IP U ETOGO DAUNA");
        }
    }

    private String urlGenerator(Object... args) {
        StringBuilder temp = new StringBuilder();
        for (Object str : args) {
            temp.append("/");
            temp.append(str.toString());
        }
        return temp.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST,consumes = "multipart/form-data")
    public void uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        System.out.println(file.getName()+" |||| "+file.getSize());
    }
}
