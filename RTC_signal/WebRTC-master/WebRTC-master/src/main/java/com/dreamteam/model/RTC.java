package com.dreamteam.model;

import org.json.JSONObject;

public class RTC {
    private JSONObject offer;
    private JSONObject answer;

    public RTC setOffer(String offer) {
        this.offer = new JSONObject(offer);
        return this;
    }

    public RTC setAnswer(String answer) {
        this.answer = new JSONObject(answer);
        return this;
    }

    public JSONObject getOffer() {
        return offer;
    }

    public JSONObject getAnswer() {
        return answer;
    }
}
