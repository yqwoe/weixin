package com.utils;

import com.models.AccessToken;
import com.repository.AccessTokenRepository;
import net.dongliu.requests.Parameter;
import net.dongliu.requests.Requests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class RestClientUtil {
    static  final String BASE_URL = "https://qyapi.weixin.qq.com/cgi-bin/";

    public static String get(String url,Map<String,Object> params){
        String resp = Requests.get(BASE_URL+url).send().readToText();
        return resp;
    }

    public static String post(String url,Map<String,Object> params){
        String resp = Requests.post(BASE_URL+url).body(params).send().readToText();
        return resp;
    }

    public static String post(String url,String params){
        String resp = Requests.post(BASE_URL+url).body(params).send().readToText();
        return resp;
    }

    public static String put(String url,Map<String,Object> params){
        String resp = Requests.put(BASE_URL+url).body(params).send().readToText();
        return resp;
    }

}
