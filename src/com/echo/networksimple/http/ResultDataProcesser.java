package com.echo.networksimple.http;

import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ResultDataProcesser {

    private Integer status;
    private String requestData;

    public ResultDataProcesser(byte[] responseBody) {
        String responseBodyInString = null;
        try {
            responseBodyInString = new String(responseBody, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject response = JSON.parseObject(responseBodyInString);
        status = Integer.valueOf(response.getString("status"));
        requestData = response.getString("values");
    }

    public String getRequestData() {
        return requestData;
    }

    public int getStatus() {
        return status;
    }
}
