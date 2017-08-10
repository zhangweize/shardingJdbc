package com.study.dangdang.sharding.jdbc.service;

import java.util.List;

import com.study.dangdang.sharding.jdbc.entity.User;

public interface UserService {
    
    boolean insert(User u);
    
    List<User> findAll(List<Long> ids);
    
    List<User> findByUserIds(List<Long> ids);
    
    void transactionTestSucess();
    
    void transactionTestFailure() throws IllegalAccessException;
    
    Integer countUser(List<Long> companys);
}
