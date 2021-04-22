package com.joseortale.ortalesoft.subredditsample.model.apiresponse;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("data")
    private ResponseData responseData;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }
}
