package dao;

import model.DBUtil;
import model.User;
import util.ChatroomException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//通过userDao这个类完成针对user表的操作
public class UserDao {
    //1：新增一个用户(注册功能)
    public void add(User user) {
        //1：获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2：拼装sql语句
        String sql = "insert into user values(null, ?, ?, ?, now())";
        /*在这里如果采用(String + )的拼接也是可以的，但是不太好
         * 1：比较麻烦费事
         * 2：容易引起sql注入攻击‘);drop table xxx’用户的恶意输入就会导致sql*/
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getNickName());

            //3：执行sql语句
            //插入，删除，修改数据，都是用的是executeUpdate()
            //查询的时候，就是使用的executeQuery()
            //返回结果是他影响的行数：也就是修改的行数，插入也就修改了一行
            int ret = statement.executeUpdate();
            if (ret != 1) {
                //出现问题的处理方式主动的抛出一个自定义的异常
                throw new ChatroomException("插入用户异常");
            }
            System.out.println("插入用户成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ChatroomException("插入用户异常");
        } finally {
            //4：释放连接
            DBUtil.close(connection, statement, null);
        }
    }
    //2：按用户名查找用户信息(登录功能)
    public User selectByName(String name) {
        //1：获取连接
        Connection connection = DBUtil.getConnection();
        //2：拼装sql语句
        String sql ="select * from user where name=?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;//写在try外面，方便finally里面释放
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,name);

            //3：执行sql语句
            resultSet =statement.executeQuery();

            //4：遍历结果集合(执行查找操作，必须要有)
            /*4.1：名字是唯一的，所以结果最多是一条或者是零条,直接使用if判定就可以了
            * 4.2：如果查找名字有多条的话，使用while循环的方式来获取
            * 4.3：如果当前resultSet.next（）直接返回的是false，说明该用户名不存在*/
            if(resultSet.next()){
                User user=new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setNickName(resultSet.getString("nickName"));
                user.setLastLogout(resultSet.getTimestamp("lastLogout"));
                return user;
            }
            //new ChatroomException("按用户名查找用户失败");
        } catch (SQLException e) {
            e.printStackTrace();
            new ChatroomException("按用户名查找用户失败");
        }
        //5：释放连接
        finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    //3：按用户id查找用户信息(把userId转换成昵称的时候)
    public User selectById(int userId){
        //1：获取连接
        Connection connection=DBUtil.getConnection();
        //2：拼接sql语句
        String sql="select * from user where userId=?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,userId);
            //3：执行语句
            resultSet=statement.executeQuery();

            //4：遍历结果集合
            if(resultSet.next()){
                User user=new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setNickName(resultSet.getString("nickName"));
                user.setLastLogout(resultSet.getTimestamp("lastLogout"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ChatroomException("按照用户id查找用户失败");
        }finally {
            //5：释放连接
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    //4：更新用户的lastLogout时间，用户下线时更新，为了实现历史记录功能
    public void updateLogout(int userId){
        //那个用户下线，就更新那个
        //1：获取连接
        Connection connection=DBUtil.getConnection();
        //2：拼接sql语句
        String sql="update user set lastLogout= now() where userId=?";
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,userId);
            //3：执行sql语句
            int ret=statement.executeUpdate();
            if(ret!=1){
                throw new ChatroomException("更新退出时间失败");
            }
            System.out.println("更新退出时间成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ChatroomException("更新退出时间失败");
        }finally {
            //4：释放连接
            DBUtil.close(connection,statement,null);
        }
    }

    public static void main(String[] args) {
        UserDao userDao=new UserDao();
        User user=new User();
        user.setName("yl");
        user.setPassword("123");
        user.setNickName("杨");
        userDao.add(user);
    }
}