package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import lombok.extern.java.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;


import java.util.Arrays;
import java.util.List;

/**
 * @author: huangxiang
 * @create: 2018/5/30 15:11
 * @description:
 */
@Log
public class GetUserListTest {

    @Test(dependsOnGroups = "loginTrue", description = "获取性别为男的用户信息接口")
    public void getUserList() throws IOException {

        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase = session.selectOne("getUserListCase", 1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);


        JSONArray result = getJsonResult(getUserListCase);
        System.out.println(result);
        List<User> userList = session.selectList(getUserListCase.getExpected(),getUserListCase);
        System.out.println(userList);

        if (result != null && userList != null) {
            for (User user : userList) {
                System.out.println("获取的用户：" + user.toString());
            }
            JSONArray userListJson = new JSONArray(userList);
            System.out.println("userListJson结果:" + userListJson);
            Assert.assertEquals(userListJson.length(), result.length());
            for (int i = 0; i < result.length(); i++) {
                JSONObject expect = (JSONObject) result.get(i);
                JSONObject actual = (JSONObject) userListJson.get(i);
                Assert.assertEquals(expect.toString(), actual.toString());
            }
        }

    }


    private JSONArray getJsonResult(GetUserListCase getUserListCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("userName",getUserListCase.getUserName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());
        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        //声明一个对象来进行响应结果的存储
        String result;
        //执行post方法
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("调用接口list result:"+result);
        JSONArray jsonArray = new JSONArray(result);



        return jsonArray;

    }



}
