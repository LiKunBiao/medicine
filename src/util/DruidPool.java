package util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//javax.sql.DataSource接口
//使用硬编码的方式(使用Properties类)，不推荐
public class DruidPool {
    protected static Connection con = null;
    protected static Statement s = null;
    protected static PreparedStatement ps = null;
    protected static ResultSet rs = null;
    protected static BasicDataSource dataSource = null;
    public static void init()//可以换成静态代码块
    {
        Properties p = new Properties();
        //InputStream resourceAsStream = DruidPool.class.getClassLoader().getResourceAsStream("配置文件");
        //p.load(resourceAsStream);
        //可以将配置文件加载成
        p.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        p.setProperty("url", "jdbc:mysql://localhost:3306/medicine");
        p.setProperty("username", "root");
        p.setProperty("password", "root");
        p.setProperty("maxActive", "30");//最大活动状态连接数
        p.setProperty("maxIdle", "10");//最大空闲状态连接数
        p.setProperty("maxWait", "1000");//请求的最长等待时间，1s
        try {
            dataSource = BasicDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        con = null;
        if(dataSource == null)
        {
            init();//初始化操作
        }
        if(dataSource != null)
        {
            try {
                con = dataSource.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return con;
    }
    public static BasicDataSource getDataSource()
    {
        if(dataSource == null)
        {
            init();//初始化操作
        }
        return dataSource;
    }
}
