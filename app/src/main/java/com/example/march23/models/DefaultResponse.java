package com.example.march23.models;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {
    //Full name comming from json
    @SerializedName("error")
    //shot name
    private boolean err;

    @SerializedName("response")
    private String resp;

    public DefaultResponse(boolean err, String resp) {
        this.err = err;
        this.resp = resp;
    }

    public boolean isErr() {
        return err;
    }

    public String getResp() {
        return resp;
    }
}
