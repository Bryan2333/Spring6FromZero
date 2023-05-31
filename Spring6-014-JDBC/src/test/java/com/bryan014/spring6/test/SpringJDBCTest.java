package com.bryan014.spring6.test;

import com.bryan014.spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpringJDBCTest {

    // 测试jdbcTemplate连接
    @Test
    public void testJDBC() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        System.out.println(jdbcTemplate);
    }

    // 添加数据
    @Test
    public void testInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "insert into t_user(real_name, age) values(?,?)";

        int rows = jdbcTemplate.update(sql, "王五", 37);

        System.out.println(rows);
    }

    // 修改数据
    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "update t_user set real_name = ?, age = ? where id = ?";

        int rows = jdbcTemplate.update(sql, "法外狂徒", 100, 1);

        System.out.println(rows);
    }

    // 删除数据
    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "delete from t_user where id = ?";

        int rows = jdbcTemplate.update(sql, 1);

        System.out.println(rows);
    }

    // 查询某个对象
    @Test
    public void testQueryOne() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "select id, real_name, age from t_user where id = ?";

        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);

        System.out.println(user);
    }

    // 查询多个对象
    @Test
    public void testQueryAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "select id, real_name, age from t_user";

        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        for (User user : users) {
            System.out.println(user);
        }
    }

    // 查询某个值
    @Test
    public void testQueryOneValue() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "select count(1) from t_user";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("总记录条数" + count);
    }

    // 批量添加数据
    @Test
    public void testBatchInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "insert into t_user(real_name, age) values(?,?)";

        Object[] objs1 = {"Smith", 21};
        Object[] objs2 = {"Peter", 22};
        Object[] objs3 = {"Milan", 24};

        List<Object[]> list = new ArrayList<>();

        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] counts = jdbcTemplate.batchUpdate(sql, list);

        System.out.println(Arrays.toString(counts));
    }

    // 批量修改数据
    @Test
    public void testBatchUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "update t_user set real_name = ?, age = ? where id = ?";

        Object[] objs1 = {"Tom", 24, 7};
        Object[] objs2 = {"Tim", 29, 8};
        Object[] objs3 = {"R", 11, 9};

        List<Object[]> list = new ArrayList<>();

        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql, list);

        System.out.println(Arrays.toString(count));
    }

    // 批量删除
    @Test
    public void testBatchDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        String sql = "delete from t_user where id = ?";

        Object[] objs1 = {8};
        Object[] objs2 = {9};

        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);

        int[] count = jdbcTemplate.batchUpdate(sql, list);

        System.out.println(Arrays.toString(count));
    }

    // JDBCTemplate中的回调函数：允许开发者写原生的jdbc代码
    @Test
    public void testCallbackFunction() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

        // 准备Sql语句
        String sql = "select id, real_name, age from t_user where id = ?";

        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<>() {
            User user = null;

            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1, 2);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String realName = resultSet.getString("real_name");
                    int age = resultSet.getInt("age");

                    user = new User(id, realName, age);
                }
                return user;
            }
        });

        System.out.println(user);
    }
}
