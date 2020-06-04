package dao;

import tool.db.DBUtil;
import xpu.vo.UserVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//这个是将用户在数据库中存取操作的类
public class UserDAO {
    private static Connection con=null;
    private Statement stmt=null;

    //也就是在实例化的时候就开始与数据库进行交互
    public UserDAO(){
        //1：建立连接
        con= DBUtil.getConnection();//这里返回的是数据库的连接

        //2：创建语句：
        try {
            stmt=con.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //上面成功将数据库进行了连接，下面可以编写操作代码
    //功能1：将对象user添加到表里面
    public void Add(UserVO user) throws SQLException {
        String sql="insert into user(username,password) values("+user.getUsername()+","
                +user.getPassword()+")";
        //3：执行语句：
        stmt.executeUpdate(sql);
    }

    //功能2：根据用户名从数据库中删除该用户：
    public void Delete(String username) throws SQLException {
        String sql="delete from user where username="+username+"";
        stmt.executeUpdate(sql);
    }

    //功能3：修改数据库中的用户信息：
    public void Update(UserVO user) throws SQLException {
        String sql="update user set password="+user.getPassword()+
                    "where username="+user.getUsername();
        stmt.executeUpdate(sql);
    }

    //功能4：根据用户名称从数据库中进行查找，并将找到的记录写到UserVO实例user对象里面，返回
    public UserVO searchByUsername(String username) throws SQLException {
        UserVO user=new UserVO();
        String sql="select * from user where username="+username+"";
        ResultSet rs=stmt.executeQuery(sql);//查询返回的是结果集
        while (rs.next()) {//通过迭代器进行循环遍历
            String name=rs.getString("username");
            if(name.equals(username)){
                //说明找到了，进行返回即可
                user.setUsername(name);
                user.setPassword(rs.getString("password"));
                if(rs!=null){
                    //如果用完了之后，一定记得关闭资源
                    rs.close();
                    return user;
                }
            }
        }
        //循环完了都没有找到，就直接返回null
        return null;
    }

    //功能5：判断用户是否存在：
    public boolean exists(String username) throws SQLException {
        boolean ue=false;
        if(searchByUsername(username)!=null){
            ue=true;//说明找到了
        }
        return ue;
    }

    //所有功能执行完了之后，记得滚逼与数据库进行连接的资源：
    public void finalize(){
        try {
            if(stmt!=null){
                stmt.close();
            }
            if(con!=null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
