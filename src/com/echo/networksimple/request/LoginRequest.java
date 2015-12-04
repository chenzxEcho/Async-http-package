package com.echo.networksimple.request;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.echo.networksimple.http.HttpRequest;
import com.echo.networksimple.http.Model;
import com.echo.networksimple.http.Request;
import com.echo.networksimple.http.UrlConfig;
import com.echo.networksimple.util.GeneralCallBack;

public class LoginRequest extends Request {

    private HttpRequest httpRequest;
    private static final String API = "";

    public LoginRequest(Context context, GeneralCallBack callback) {
        super(context, callback);
        httpRequest = new HttpRequest(context, callback);
    }

    @Override
    public void sendPostRequest(String requestType, Model model) {
        Map params = new HashMap<String, String>();
        String requestDataInJson = JSON.toJSONString(params);
        String requestUrl = UrlConfig.getHttpUrlWithToken(API, requestType);
        httpRequest.AsyncHttpClientPost(requestType, requestDataInJson,
                requestUrl);
    }

    @Override
    public void sendGetRequest(String requestType, Model model) {
        Map params = new HashMap<String, String>();
        String requestDataInJson = JSON.toJSONString(params);
        String requestUrl = UrlConfig.getHttpUrlWithToken(API, requestType);
        httpRequest.AsyncHttpClientGet(requestType, requestDataInJson,
                requestUrl);
    }

}
