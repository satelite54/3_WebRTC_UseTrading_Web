package com.dreamteam.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<RTC> connections;

    private boolean hasOffer = false;
    private boolean hasAnswer = false;

    public Room() {
        connections = new ArrayList<>();
    }

    public Room(RTC connection) {
        super();
        connections.add(connection);
    }

    public void add(RTC rtc) {
        hasAnswer = rtc.getAnswer() != null;
        hasOffer = rtc.getOffer() != null;
        connections.add(rtc);
    }

    public List<RTC> getConnections() {
        return connections;
    }

    public int getUsersCount() {
        return connections.size();
    }

    public JSONObject getOffer() {
        for (RTC connection: connections) {
            JSONObject offer = connection.getOffer();
            if (offer != null) {
                return offer;
            }
        }
        throw new RuntimeException("No offers");
    }

    public JSONObject getAnswer() {
        for (RTC connection: connections) {
            JSONObject answer = connection.getOffer();
            if (answer != null) {
                return answer;
            }
        }
        throw new RuntimeException("No answers");
    }

    public boolean hasOffer() {
        return hasOffer;
    }

    public boolean hasAnswer() {
        return hasAnswer;
    }

    public boolean empty() {
        return connections.isEmpty();
    }
}
