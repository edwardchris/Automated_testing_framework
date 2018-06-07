package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author: huangxiang
 * @create: 2018/5/30 15:11
 * @description:
 */
public class GetUserListTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的用户信息接口")
    public void getUserList() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase = session.selectOne("getUserListCase",1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);

    }
}
