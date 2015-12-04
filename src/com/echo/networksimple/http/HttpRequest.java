package com.echo.networksimple.http;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.echo.networksimple.util.GeneralCallBack;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * @author ctmwd
 * @time 下午1:09:40
 * @date 2015年9月23日
 * @description 网络请求基础类，所有网络请求的类都需要继承此类。
 */
public class HttpRequest {
    private final Context mContext;
    private HttpEntity entity = null;
    private GeneralCallBack mGeneralCallBack;

    public HttpRequest(Context context, GeneralCallBack callBack) {
        this.mContext = context;
        mGeneralCallBack = callBack;
    }

    public void AsyncHttpClientPost(final String requestType,
            String requestDataInJson, String requestUrl) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.setMaxRetriesAndTimeout(0, 5000);
        try {
            this.entity = new StringEntity(requestDataInJson, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        client.post(this.mContext, requestUrl, this.entity, "application/json",
                new AsyncHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers,
                            byte[] responseBody) {
                        HttpRequest.this.RequestSuccess(requestType,
                                statusCode, headers, responseBody);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                            byte[] responseBody, Throwable error) {
                        HttpRequest.this.RequestFailed(requestType, statusCode,
                                headers, null);
                    }
                });
    }

    public void AsyncHttpClientGet(final String requestType,
            String requestDataInJson, String requestUrl) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.setMaxRetriesAndTimeout(0, 5000);
        try {
            this.entity = new StringEntity(requestDataInJson, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        client.get(this.mContext, requestUrl, this.entity, "application/json",
                new AsyncHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers,
                            byte[] responseBody) {
                        HttpRequest.this.RequestSuccess(requestType,
                                statusCode, headers, responseBody);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                            byte[] responseBody, Throwable error) {
                        HttpRequest.this.RequestFailed(requestType, statusCode,
                                headers, null);
                    }
                });
    }

    protected void RequestSuccess(String requestType, int statusCode,
            Header[] headers, byte[] responseBody) {

        Log.i("HELLOWORLD SUCCESSED", requestType.toString());

        ResultDataProcesser processer = new ResultDataProcesser(responseBody);
        mGeneralCallBack.onComplete(requestType, processer.getStatus(),
                processer.getRequestData());
    }

    protected void RequestFailed(String requestType, int statusCode,
            Header[] headers, byte[] responseBody) {
        Log.i("HELLOWORLD FAILED", requestType.toString());

    }
}
