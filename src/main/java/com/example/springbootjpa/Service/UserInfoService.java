package com.example.springbootjpa.Service;

import com.example.springbootjpa.entity.UserInfo;
import com.example.springbootjpa.jpa.UserInfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Y.sh
 * @date 2019/9/29 15:50
 * @Description
 */
@Service
@CacheConfig(cacheNames = "userinfo")
public class UserInfoService {

    @Autowired
    private UserInfoJpa userInfoJpa;

    @Cacheable
    public List<UserInfo> findAll(){
        return userInfoJpa.findAll();
    }

    @Cacheable
    public UserInfo findByNameAndAddress(String name,String address){
        return userInfoJpa.findByNameAndAddress(name, address);
    }

    @Cacheable
    public Optional<UserInfo> findById(Long id){
        return userInfoJpa.findById(id);
    }
}
