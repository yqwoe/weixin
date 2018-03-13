package com.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.AccessToken;
import com.repository.AccessTokenRepository;
import com.utils.RestClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {
    @Autowired
    AccessTokenRepository accessTokenRepository;

    @RequestMapping("/demo")
    public String index() throws Exception{
            Map<String,Object> params = new HashMap<String, Object>();
            params.put("corpid","ww8a0f3264e1e38e42");
            params.put("corpsecret","8yPsPdeWU36ma0TBVSN0zjCNG1bBcEJ7Tl0ZFFnE1DU");
            String result = RestClientUtil.get("gettoken?corpid=ww8a0f3264e1e38e42&corpsecret=Z3rMnYK0iGe7GcihrUBsayGxVNcjPMx_oykJdgfCsFQ",params);
            ObjectMapper objectMapper = new ObjectMapper();
            AccessToken accessToken = objectMapper.readValue(result, AccessToken.class);
            accessTokenRepository.save(accessToken);
        return "ok";
    }
}
