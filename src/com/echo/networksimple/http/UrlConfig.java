package com.echo.networksimple.http;

import com.echo.networksimple.util.MD5Utils;

/**
 * @author ctmwd
 * @time 下午1:11:06
 * @date 2015年9月23日
 * @description app功能所需地址配置
 */
public class UrlConfig {
    private final static String BASE_URL = "tenon-x.com/";

    private final static String BASE_HTTP_URL = "http://" + BASE_URL;

    private final static String BASE_HTTPS_URL = "https://" + BASE_URL;

    private final static String MD5_BASE = "";

    public static String getBaseHttpUrl() {
        return BASE_HTTP_URL;
    }

    public static String getBaseHttpsUrl() {
        return BASE_HTTPS_URL;
    }

    public static String getHttpUrlWithApi(String Api) {
        if (Api != null) {
            return BASE_HTTP_URL + Api + "/";
        } else {
            return BASE_HTTP_URL;
        }
    }

    public static String getHttpsUrlWithApi(String Api) {
        if (Api != null) {
            return BASE_HTTPS_URL + Api + "/";
        } else {
            return BASE_HTTPS_URL;
        }
    }

    public static String getHttpUrlWithRequestType(String Api,
            String requestType) {
        return getHttpUrlWithApi(Api) + requestType;
    }

    public static String getHttpsUrlWithRequestType(String Api,
            String requestType) {
        return getHttpsUrlWithApi(Api) + requestType;
    }

    public static String getHttpUrlWithSeed(String Api, String requestType) {
        return getHttpUrlWithRequestType(Api, requestType) + "?seed="
                + System.currentTimeMillis() / 1000;
    }

    public static String getHttpsUrlWithSeed(String Api, String requestType) {
        return getHttpUrlWithRequestType(Api, requestType) + "?seed="
                + System.currentTimeMillis() / 1000;
    }

    public static String getHttpUrlWithToken(String Api, String requestType) {
        return getHttpUrlWithSeed(Api, requestType)
                + "&token="
                + MD5Utils
                        .getToken(MD5_BASE, System.currentTimeMillis() / 1000);
    }

    public static String getHttpsUrlWithToken(String Api, String requestType) {
        return getHttpsUrlWithSeed(Api, requestType)
                + "&token="
                + MD5Utils
                        .getToken(MD5_BASE, System.currentTimeMillis() / 1000);
    }

    public static String getHttpUrlWithSign(String Api, String requestType,
            String requestDataInJson) {
        return getHttpUrlWithToken(Api, requestType) + "&sign="
                + MD5Utils.getToken(MD5_BASE, requestDataInJson);
    }

    public static String getHttpsUrlWithSign(String Api, String requestType,
            String requestDataInJson) {
        return getHttpsUrlWithToken(Api, requestType) + "&sign="
                + MD5Utils.getToken(MD5_BASE, requestDataInJson);
    }
}
