package com.controller;

import com.repository.AccessTokenRepository;
import com.utils.RestClientUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.AccessToken;
import com.models.Department;
import com.models.DepartmentResponse;
import com.models.User;
import com.repository.UserRepository;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccessTokenRepository accessTokenRepository;
    //https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ww8a0f3264e1e38e42&corpsecret=Z3rMnYK0iGe7GcihrUBsayGxVNcjPMx_oykJdgfCsFQ

    //初始化RestClient实例
    static  RestClient restClient = RestClient.builder(
            new HttpHost("qyapi.weixin.qq.com", 80, "https")).build();

    @GetMapping(value = {"","/index"})
//    @ResponseBody
    public String index(String page ,String pageSize,Model model) throws Exception{
        if(page == null)
            page = "1";
        if(pageSize == null )
            pageSize = "20";
        Page<User> users = userRepository.findAll(new PageRequest(Integer.valueOf(page),Integer.valueOf(pageSize),Sort.Direction.DESC,"id"));
        model.addAttribute("users",users);
        return "users/index";
    }

    @GetMapping("/new")
    public String new_user(Model model){
        return "users/new";
    }

}
