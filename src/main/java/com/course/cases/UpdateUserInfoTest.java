package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author: huangxiang
 * @create: 2018/5/30 15:11
 * @description:
 */
public class UpdateUserInfoTest {
    @Test(dependsOnGroups = "loginTrue", description = "更新用户信息接口")
    public void updateUserInfo() throws IOException, InterruptedException {

        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase", 1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);


        int result = getResult(updateUserInfoCase);

        User user = session.selectOne(updateUserInfoCase.getExpected(), updateUserInfoCase);

        if (result != 0 && user != null) {
            Assert.assertNotNull(result);
            Assert.assertNotNull(user);
        }


    }


    @Test(dependsOnGroups = "loginTrue", description = "删除用户信息接口")
    public void deleteUserInfo() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase", 2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);

        int result = getResult(updateUserInfoCase);
        Thread.sleep(3000);
        User user = session.selectOne(updateUserInfoCase.getExpected(), updateUserInfoCase);

        if (result != 0 && user != null) {
            Assert.assertNotNull(result);
            Assert.assertNotNull(user);
        }
    }

    private int getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.updateUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("id", updateUserInfoCase.getUserId());
        param.put("userName", updateUserInfoCase.getUserName());
        param.put("sex", updateUserInfoCase.getSex());
        param.put("age", updateUserInfoCase.getAge());
        param.put("permission", updateUserInfoCase.getPermission());
        param.put("isDelete", updateUserInfoCase.getIsDelete());

        post.setHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(param.toString(), "UTF-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(), "UTF-8");


        return Integer.parseInt(result);
    }
}
