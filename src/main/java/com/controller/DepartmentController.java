package com.controller;


import com.models.AccessToken;
import com.models.Department;
import com.repository.AccessTokenRepository;
import com.repository.DepartmentRepository;
import com.utils.RestClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    AccessTokenRepository accessTokenRepository;

    @GetMapping(value = {"","/index"})
    String index(Model model){
        return "departments/index";
    }

    @GetMapping("/new")
    String new_department(Model model){
        return "departments/new";
    }

    @PostMapping
    String create(@ModelAttribute  Department department, Model model){
        System.out.printf(department.getName());
        Department after = departmentRepository.save(department);
        String accessToken = accessToken();
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("id",after.getId());
        params.put("name",after.getName());
        params.put("parentid",after.getParentid());
        params.put("order",after.getOrder());
        String resp = RestClientUtil.post("department/create?access_token="+accessToken,params);
        System.out.printf(resp);
        return "departments/index";
    }

    public String accessToken(){
        List<AccessToken> accessTokens = accessTokenRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
        AccessToken token = accessTokens.get(0);
        String accessToken = token.getAccess_token();
        return accessToken;
    }
}
