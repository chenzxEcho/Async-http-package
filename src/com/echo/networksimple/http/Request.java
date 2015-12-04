package com.echo.networksimple.http;

import android.content.Context;

import com.echo.networksimple.util.GeneralCallBack;

public abstract class Request {

    public Request(Context context, GeneralCallBack callback) {

    }

    public abstract void sendPostRequest(String requestType, Model model);

    public abstract void sendGetRequest(String requestType, Model model);
}
