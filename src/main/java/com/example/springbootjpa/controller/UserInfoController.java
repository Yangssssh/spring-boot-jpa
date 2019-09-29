package com.example.springbootjpa.controller;

import com.example.springbootjpa.Service.UserInfoService;
import com.example.springbootjpa.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public UserInfo find(int id){
        Optional<UserInfo> optional=userInfoService.findById((long) id);
        return optional.get();
    }

    @RequestMapping(value = "/find2",method = RequestMethod.GET)
    public UserInfo find2(String name,String address){
       return userInfoService.findByNameAndAddress(name, address);
    }

    @RequestMapping(value = "/list")
    public List<UserInfo> findList(){
        return userInfoService.findAll();
    }
}
