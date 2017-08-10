package com.study.dangdang.sharding.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dangdang.sharding.jdbc.entity.Company;
import com.study.dangdang.sharding.jdbc.mapper.CompanyMapper;
import com.study.dangdang.sharding.jdbc.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    
    @Autowired
    private CompanyMapper companyMapper; 
    
    public boolean insert(Company company) {
        return companyMapper.insert(company) > 0 ? true : false;  
    }
    
    public Integer countAllCompany() {
        return companyMapper.countAllCompany();
    }
}
