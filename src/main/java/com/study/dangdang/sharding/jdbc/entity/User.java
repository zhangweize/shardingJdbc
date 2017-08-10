package com.study.dangdang.sharding.jdbc.entity;

import java.io.Serializable;

public class User implements Serializable{
    
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 1L;

    private Long id;
    
    private Long companyId;
    
    private String name;
    
    private Integer age;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getCompanyId() {
        return companyId;
    }


    
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }


    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public Integer getAge() {
        return age;
    }

    
    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=");
        builder.append(id);
        builder.append(", companyId=");
        builder.append(companyId);
        builder.append(", name=");
        builder.append(name);
        builder.append(", age=");
        builder.append(age);
        builder.append("]");
        return builder.toString();
    }

    
    
    
}
