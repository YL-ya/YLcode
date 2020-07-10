package yl.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import yl.exception.SystemException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//数据库的工具类：
public class DBUtil {
    private static final String URL="jdbc:mysql://localhost:3306/book";
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    
    
    private static volatile DataSource DATA_SOURCE;
    
    private DBUtil(){
    }
    //双重校验锁的写法：获取数据库连接池
    private static DataSource getDataSource(){
        if(DATA_SOURCE==null){
            synchronized (DBUtil.class){
                if(DATA_SOURCE==null){
                    DATA_SOURCE=new MysqlDataSource();
                    ((MysqlDataSource) DATA_SOURCE).setUrl(URL);
                    ((MysqlDataSource) DATA_SOURCE).setUser(USERNAME);
                    ((MysqlDataSource) DATA_SOURCE).setPassword(PASSWORD);
                }
            }
        }
        return DATA_SOURCE;
    }

    //提供对外链接
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new SystemException("000001","获取数据库连接失败",e);
        }
    }
    //如果数据库jdbc操作费查询结果的
    public static void close(Connection c,Statement s){
        close(c,s,null);
    }
    //关闭数据库jdbc的资源
    public static void close(Connection c, Statement s, ResultSet r){
        //反向释放
        try {
            if(r!=null){
                r.close();
            }
            if(s!=null){
                s.close();
            }
            if(c!=null){
                c.close();
            }
        } catch (SQLException e) {
            throw new SystemException("000002","释放数据库资源出错",e);
        }
    }
}
