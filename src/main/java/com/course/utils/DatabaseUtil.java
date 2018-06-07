package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: huangxiang
 * @create: 2018/5/30 11:22
 * @description:
 */
public class DatabaseUtil {

    public static SqlSession getSqlSession() throws IOException {
        /**
         * 获取配置的资源文件
         */
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = factory.openSession();


        return sqlSession;
    }

}
