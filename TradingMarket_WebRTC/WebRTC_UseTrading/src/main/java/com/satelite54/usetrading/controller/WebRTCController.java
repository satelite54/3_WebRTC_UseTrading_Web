package com.satelite54.usetrading.controller;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.satelite54.RTC.model.Room;

@Controller
@RequestMapping(value = "/webrtc")
public class WebRTCController {
	
    private HashMap<Integer, Room> rooms = new HashMap<>();

    private Logger logger = Logger.getLogger(this.getClass().getName());

	
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
}
