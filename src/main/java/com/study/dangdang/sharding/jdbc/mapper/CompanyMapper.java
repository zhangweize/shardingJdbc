package com.study.dangdang.sharding.jdbc.mapper;

import java.util.List;

import com.study.dangdang.sharding.jdbc.entity.Company;

public interface CompanyMapper {
    Integer insert(Company s);
    Integer countAllCompany();
}
