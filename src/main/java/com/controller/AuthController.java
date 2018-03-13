package com.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.AccessToken;
import com.models.UserResponse;
import com.utils.RestClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import com.utils.WXAuth;

@Controller
public class AuthController {


    @GetMapping("/auth/wx")
    String auth2wx(Model model){
        String back_url = URLEncoder.encode("http://yqwoe.com/auth/back");
        String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=ww8a0f3264e1e38e42&redirect_uri="+back_url+"&response_type=code&scope=snsapi_userinfo&agentid=1000002&state=STATE#wechat_redirect";
        return "redirect:"+oauth2Url;
    }

    @GetMapping("/auth/back")
    String auth2me(HttpServletRequest request, @RequestParam String code , Model model) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("code",code);
        String accessToken = WXAuth.accessToken();
        Map<String,Object> userResponse = WXAuth.getUserId(accessToken,code);
        session.setAttribute("user",userResponse);
        Map<String,Object> userinfo = WXAuth.getUserInfo(accessToken,userResponse.get("user_ticket").toString());
        session.setAttribute("userinfo",userinfo);
        return "auth/back";
    }


}
