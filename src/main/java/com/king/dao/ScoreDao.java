package com.king.dao;

import com.king.entity.Score;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class ScoreDao {
    public Score getScoreByID(int id){
        InputStream inputStream = ScoreDao.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Score score = sqlSession.selectOne("com.king.dao.ScoreMapper.selectScoreByID",2);
        return score;
    }

    public static void main(String[] args) {
        ScoreDao scoreDao = new ScoreDao();
        System.out.println(scoreDao.getScoreByID(1));
    }
}
