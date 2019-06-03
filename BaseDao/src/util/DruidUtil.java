package util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtil {
    private final static Properties properties;
    private static ThreadLocal<DruidDataSource> threadLocal = new ThreadLocal<>();
    private static DruidDataSource dataSource;

    static {
        properties = new Properties();
        try {
            properties.load(DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DruidDataSource getDataSource(){
        if (threadLocal.get()!=null){
            return threadLocal.get();
        }
        threadLocal.set(dataSource);
        return dataSource;
    }
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
