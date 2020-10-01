package com.mybatis.dao;import com.mybatis.pojo.User;import com.mybatis.util.MybatisUtils;import org.apache.ibatis.session.SqlSession;import org.junit.Test;import java.util.List;/** * <p> * 测试类 * </p> * * @author lipeilong * @time 2020/9/30 21:17 * @description 测试类 */public class UserMapperTest {    @Test    public void testUserList() {        SqlSession sqlSession = null;        try {            //使用，构造sqlsession            sqlSession = MybatisUtils.getSqlSession();            //使用sqlsession            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);            List<User> userList = userMapper.getUserList();            userList.forEach(System.out::println);        } catch (Exception exception) {            exception.printStackTrace();        } finally {            sqlSession.close();        }    }    @Test    public void testGetUserById() {        SqlSession sqlSession = MybatisUtils.getSqlSession();        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);        User user = userMapper.getUserById(1);        System.out.println(user);        sqlSession.close();    }    @Test    public void insertTest() {        SqlSession sqlSession = MybatisUtils.getSqlSession();        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);        User user = new User(4, "pillow", "lipeilong");        userMapper.addUser(user);        sqlSession.commit();        sqlSession.close();    }    @Test    public void updateTest() {        SqlSession sqlSession = MybatisUtils.getSqlSession();        UserMapper mapper = sqlSession.getMapper(UserMapper.class);        User user = new User(4, "沛隆", "lpl");        mapper.updateUser(user);        sqlSession.commit();        sqlSession.close();    }    @Test    public void deleteByIdTest() {        SqlSession sqlSession = MybatisUtils.getSqlSession();        UserMapper mapper = sqlSession.getMapper(UserMapper.class);        mapper.deleteUserById(4);        sqlSession.commit();        sqlSession.close();    }}