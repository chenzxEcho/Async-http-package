package com.echo.networksimple;

import com.echo.networksimple.http.Model;
import com.echo.networksimple.http.Request;
import com.echo.networksimple.http.RequestType;
import com.echo.networksimple.model.LoginModel;
import com.echo.networksimple.request.LoginRequest;
import com.echo.networksimple.util.GeneralCallBack;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements GeneralCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Model model = new LoginModel();
        Request request = new LoginRequest(this, this);
        request.sendGetRequest(RequestType.LOG_POST, model);
    }

    @Override
    public void onComplete(String requestType, int status, String responseBody) {
        // TODO Auto-generated method stub

    }

}
