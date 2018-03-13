package com.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.AccessToken;

import java.util.HashMap;
import java.util.Map;

public class WXAuth {


    public static String accessToken() throws Exception{
        String result = RestClientUtil.get("gettoken?corpid=ww8a0f3264e1e38e42&corpsecret=Z3rMnYK0iGe7GcihrUBsayGxVNcjPMx_oykJdgfCsFQ",null);
        ObjectMapper objectMapper = new ObjectMapper();
        AccessToken accessToken = objectMapper.readValue(result, AccessToken.class);
        return accessToken.getAccess_token();
    }

    public static  Map<String,Object> getUserId(String accessToken, String code) throws Exception{
        String result = RestClientUtil.get("user/getuserinfo?access_token="+accessToken+"&code="+code,null);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(result);
        Map<String,Object> userResponse = objectMapper.readValue(result, Map.class);
        return userResponse;
    }

    public static Map<String,Object> getUserInfo(String accessToken,String user_ticket)throws Exception{
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("user_ticket",user_ticket);
        System.out.println(accessToken);
        String result = RestClientUtil.post("user/getuserdetail?access_token="+accessToken+"&user_ticket="+user_ticket,"{\"user_ticket\":\""+user_ticket+"\"}");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(result);
        Map<String,Object> userResponse = objectMapper.readValue(result, Map.class);
        return userResponse;
    }
}
