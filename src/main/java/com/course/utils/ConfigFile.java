package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author: huangxiang
 * @create: 2018/5/30 11:09
 * @description:
 */
public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name) {
        String address = bundle.getString("test.url");
        String uri ;
        String testUrl;

        if (name == InterfaceName.GETUSERLIST) {
            uri = bundle.getString("getUserList.uri");
        } else if (name == InterfaceName.ADDUSER) {
            uri = bundle.getString("addUser.uri");
        } else if (name == InterfaceName.GETUSERINFO) {
            uri = bundle.getString("getUserInfo.uri");
        } else if (name == InterfaceName.LOGIN) {
            uri = bundle.getString("login.uri");
        } else {
            uri = bundle.getString("updateUserInfo.uri");
        }


        testUrl = address + uri;
        return testUrl;
    }
}
