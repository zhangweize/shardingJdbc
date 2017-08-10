package com.study.dangdang.sharding.jdbc.service;

import com.study.dangdang.sharding.jdbc.entity.Company;

public interface CompanyService {
    boolean insert(Company company);
    Integer countAllCompany();
}
