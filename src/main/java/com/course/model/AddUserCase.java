package com.course.model;

import lombok.Data;

/**
 * @author: huangxiang
 * @create: 2018/5/29 15:41
 * @description:
 */
@Data
public class AddUserCase {

    private int id;
    private String userName;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;


    @Override
    public String toString() {
        return (
                "{id:" + id + "," +
                "userName:" + userName + "," +
                "password:" + password + "," +
                "age:" + age + "," +
                "sex:" + sex + "," +
                "permission:" + permission + "," +
                "isDelete:" + isDelete +
                "expected:" + expected + "}"
        );

    }
}
