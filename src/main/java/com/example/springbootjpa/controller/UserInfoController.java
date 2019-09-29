package com.example.springbootjpa.controller;

import com.example.springbootjpa.entity.UserInfo;
import com.example.springbootjpa.jpa.UserInfoJpa;
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
    private UserInfoJpa userInfoJpa;

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public UserInfo find(int id){
        Optional<UserInfo> optional=userInfoJpa.findById((long) id);
        return optional.get();
    }

    @RequestMapping(value = "/find2",method = RequestMethod.GET)
    public UserInfo find2(String name,String address){
       return userInfoJpa.findByNameAndAddress(name, address);
    }
}
