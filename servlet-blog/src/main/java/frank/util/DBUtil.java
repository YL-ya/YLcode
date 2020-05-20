package frank.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import frank.exception.SystemException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
//数据库的一个工具类：作用：连接数据，返回给我们进行调用
//连接数据库

/* 获取数据库连接池，在这里要保证多线程获取连接的安全：要用到单利模式：双重校验锁的写法
 * 面试可能怎么考？
 * 1：编码写出来：一定要写双重校验锁
 * 2：谈谈单列、及实现方法：把知道的实现方法都说出来：
 *           非线程安全：饿汉式，懒汉式，
 *           线程安全：双重校验锁，静态内部类，匿名内部类
 * 3：线程安全的单例模式，把代码表达出来
 *        只需要说双重校验锁的代码就行：
 *        (1)：DCL(双重校验锁的英文缩写)
 *        (2)：两次null判断，第一次保证效率，第二次保证是同一个对象
 *        (3)：中间使用synchronized加锁，保证对象赋值操作原子性
 *        (4)：共享变量表达要完整(volatile)，保证可见性，禁止指令重排序--->具体volatile的细节即可
 * 4：双重校验的内部细节：两次判断，一次加锁，变量使用volatile，每个地方都要知道为什么*/
public class DBUtil {
    private static final String URL="jdbc:mysql://localhost:3306/blogdemo ";
    private static final String USERNAME="root";
    private static final String PASSWORD="root ";
    private static volatile DataSource DS;

    //别的通过调用getDataSource方法，可以唯一的连接一个数据库连接
    private static DataSource getDataSource(){
        if(DS==null){
            synchronized (DBUtil.class){
                if(DS==null){
                    DS=new MysqlDataSource();
                    ((MysqlDataSource)DS).setUrl(URL);
                    ((MysqlDataSource)DS).setUser(USERNAME);
                    ((MysqlDataSource)DS).setPassword(PASSWORD);
                }
            }
        }
        return DS;
    }

    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e){
            throw new SystemException("000","获取数据库连接失败",e);
        }
    }
}
