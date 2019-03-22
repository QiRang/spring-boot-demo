package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {
    @Autowired //自动注入
    DataSource dataSource;
    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());//输出看一下是什么数据源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);//查看是否获取到了连接
        connection.close();
    }

}
