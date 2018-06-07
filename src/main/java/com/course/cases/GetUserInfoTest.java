package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author: huangxiang
 * @create: 2018/5/30 15:10
 * @description:
 */
public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取userid为1的用户信息接口")
    public void getUserInfo() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = session.selectOne("getUserInfoCase",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);

    }
}
