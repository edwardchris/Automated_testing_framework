package com.course.model;

import lombok.Data;

/**
 * @author: huangxiang
 * @create: 2018/5/30 09:42
 * @description:
 */
@Data
public class UpdateUserInfoCase {

    private int id;
    private int userId;
    private String userName;
    private String sex;
    private String age;
    private String permission;
    private String isDelete;
    private String expected;

}
