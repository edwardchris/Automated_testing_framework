package com.course.model;

import lombok.Data;

/**
 * @author: huangxiang
 * @create: 2018/5/29 15:41
 * @description:
 */
@Data
public class AddUserCase {


    private String userName;
    private String password;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;

}
