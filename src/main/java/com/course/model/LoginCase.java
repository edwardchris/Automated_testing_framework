package com.course.model;

import lombok.Data;

/**
 * @author: huangxiang
 * @create: 2018/5/30 09:42
 * @description:
 */
@Data
public class LoginCase {

    private int id;
    private String userName;
    private String password;
    private String expected;

}
