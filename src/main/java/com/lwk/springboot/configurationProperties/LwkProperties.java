package com.lwk.springboot.configurationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自定义配置文件
 * Created by R9L4H0W on 2016/2/29.
 */
@ConfigurationProperties(locations = "classpath:lwk.properties")
public class LwkProperties {

    private String name;
    private int age;
    private  String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
