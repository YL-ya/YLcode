package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* 1:功能：帮助我们管理连接。DBUtil本质上是实现了DataSource类的单例版本
* 2:对于一个应用程序来说，DataSource只需要有一个实例(正好就可以使用我们的单例模式)就可以了。
* 3:单例模式是面试中最常考的设计模式
* 4:饿汉模式比较简单，但是懒汉模式比较常考一些
* 5:注意线程安全问题
*   5.1:合适的位置加锁
*   5.2:双重if判断
*   5.3:volatile*/
public class DBUtil {
    private static final String URL="jdbc:mysql://127.0.0.1:3306/chatroom?character=utf-8&useSSL=true";//useSSL加密连接
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static volatile DataSource dataSource=null;

    //建立连接：
    public static DataSource getDataSource(){
        //获取到这个单例的DataSource实例
        if(dataSource==null) {//只要实例创建好了之后，我们就不用再竞争锁了
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    //new一个DataSource的实例

                    //必须要告诉代码，数据库是谁，以啥样的方式登录上去
                    /*这里是存在一个向下转型的，因为原本的DataSource是无法进行设置URL，User等的
                    * 1：DataSource是java标准库中的类，这个类烤炉到个或者那个数据库的情况
                    * (因为有的数据库是不用进行设置用户名密码的)
                    * 2：DataSource并不负责具体如何和对应的数据库连接，
                    * 这个事情都交给子类(数据库驱动)MysqlDataSource来完成*/
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    //获取连接：
    /*1：和数据库简历连接，本质上mysql是一个“客户端，服务器”结构，
    2：数据库的本体就是服务器(数据库的存储和管理都是在服务器端完成的)
    3：咱们现在写的jdbc代码，本质上就是实现一个客户端用来连接mysql服务器
    4：mysql也是通过TCP协议进行通信的，所以要进行建立连接(应用层协议的连接(基于TCP的)(所以说首先的进行tcp连接))过程中，
        其中有一个环节会(TCP的三次握手)的操作
    5：如果建立连接失败的话，getConnection就会抛出异常，根据异常信息来确定问题的原因*/
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //如果出现异常，获取不到连接直接返回null
        return null;
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
