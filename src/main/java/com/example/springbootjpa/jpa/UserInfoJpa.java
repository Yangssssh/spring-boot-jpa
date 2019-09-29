package com.example.springbootjpa.jpa;

import com.example.springbootjpa.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoJpa extends JpaRepository<UserInfo,Long> {

    UserInfo findByNameAndAddress(String name,String address);
}
