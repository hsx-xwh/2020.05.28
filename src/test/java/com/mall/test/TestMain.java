package com.mall.test;

import com.mall.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class TestMain {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SlqMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        sqlSession.insert("com.mall.dao.UserMapper.insert",user);
        sqlSession.commit();
        sqlSession.close();

    }
}
