package top.soft.bookonline.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    private static DataSource ds;

    static {
        try {
            // 1、加载配置文件
            Properties pro = new Properties();
            // 使用 ClassLoader加载配置文件，获取字节输入流
            InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(inputStream);
            // 2、初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = ds.getConnection();
        if (connection == null) {
            throw new SQLException("无法获取数据库连接");
        }
        return connection;
    }
}