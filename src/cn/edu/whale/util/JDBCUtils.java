package cn.edu.whale.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: hexin Liu
 * @Description: JDBC工具类，使用Druid连接池
 * @Date: Created in 14:02 2019/10/26
 * @Modified By：
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        //加载配置文件
        Properties prop = new Properties();
        try {
            prop.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象
    public static DataSource getDataSource() {
        return ds;
    }

    //获取连接Connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}