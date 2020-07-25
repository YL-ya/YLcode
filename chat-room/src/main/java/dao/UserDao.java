package dao;

import model.DBUtil;
import model.User;
import util.ChatroomException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//通过userDao这个类完成针对user表的操作
public class UserDao {
    //1：新增一个用户(注册功能)
    public void add(User user){
        //1：获取数据库连接
        Connection connection= DBUtil.getConnection();
        //2：拼装sql语句
        String sql="insert into user values(null, ?, ?, ?, now())";
        /*在这里如果采用(String + )的拼接也是可以的，但是不太好
        * 1：比较麻烦费事
        * 2：容易引起sql注入攻击‘);drop table xxx’用户的恶意输入就会导致sql*/
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getNickName());

            //3：执行sql语句
            //插入，删除，修改数据，都是用的是executeUpdate()
            //查询的时候，就是使用的executeQuery()
            //返回结果是他影响的行数：也就是修改的行数，插入也就修改了一行
            int ret=statement.executeUpdate();
            if(ret!=1){
                //出现问题的处理方式主动的抛出一个自定义的异常
                throw new ChatroomException("插入用户异常");
            }
            System.out.println("插入用户成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ChatroomException("插入用户异常");
        }finally {
            
        }

        //4：释放连接
    }
    //2：按用户名查找用户信息(登录功能)
    //3：按用户id查找用户信息(把userId转换成昵称的时候)
    //4：更新用户的lastLogout时间，用户下线时更新，为了实现历史记录功能
}
