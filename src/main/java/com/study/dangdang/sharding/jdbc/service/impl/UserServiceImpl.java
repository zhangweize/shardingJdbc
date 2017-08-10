package com.study.dangdang.sharding.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.dangdang.sharding.jdbc.entity.User;
import com.study.dangdang.sharding.jdbc.mapper.UserMapper;
import com.study.dangdang.sharding.jdbc.service.UserService;
import com.study.dangdang.sharding.jdbc.unit.SnowflakeIdWorker;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    public UserMapper userMapper;
    
    
    private SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
   

    public boolean insert(User u) {
        return userMapper.insert(u) > 0 ? true :false;
    }

    public List<User> findAll(List<Long> ids) {
        return userMapper.findAll(ids);
    }

    public List<User> findByUserIds(List<Long> ids) {
        return userMapper.findByUserIds(ids);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void transactionTestSucess() {
        for(int i=0;i<10;i++) {
            User u = new User();
            u.setId(idWorker.nextId());
            u.setCompanyId(342671314403721216L);
            u.setAge(25);
            u.setName("war3 1.27");
            userMapper.insert(u);
        }
        
        
       
    }

    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public void transactionTestFailure() throws IllegalAccessException {
        User u = new User();
        u.setId(idWorker.nextId());
        u.setCompanyId(342671314403721216L);
        u.setAge(25);
        u.setName("war5 1.27 good");
        userMapper.insert(u);
        
        
        throw new IllegalAccessException();
    }

    public Integer countUser(List<Long> companys) {
        return userMapper.countUser(companys);
    }

   
   
    
}
