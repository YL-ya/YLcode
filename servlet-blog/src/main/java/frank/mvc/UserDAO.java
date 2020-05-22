package frank.mvc;

import java.sql.*;

//主要用来获得数据库对象：进行操作：
public class UserDAO {
    //将连接封装成一个方法：
    static Connection con;
    public static Connection getConnection(){
        try {
            //1：加载驱动：
            Class.forName("com.mysql.jdbc.Driver");//mysql公司的驱动

            //2：建立连接：
            if(con==null) {
                //如果第一次建立连接的话，进行建立连接，并返回连接对象
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
            }
            //如果不是第一次，那么直接返回连接对象：这样的话，所有的客户都共用一个连接，是有问题的
            //使用连接池的技术
            return con;//连接成功
        } catch (ClassNotFoundException e) {
            e.printStackTrace();//这里是驱动找不到的异常
            return null;
        } catch (SQLException e) {
            e.printStackTrace();//操作sql异常
            return null;
        }
    }

    public UserDAO(){
        UserDAO.getConnection();
    }
    /*public int save(UserVO user){//将客户端传过来的数据存放在UserVO里面，并插在数据库里面
        //3：创建语句：
        try {
            Statement st=con.createStatement();
            String sql="insert into T_User values('"+user.getUsername()+"','"+user.getPassword()+"')";
            int rows=st.executeUpdate(sql);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
            //出现异常一般返回的是-1
            return -1;
        }
    }*/

    public int save(UserVO user){//将客户端传过来的数据存放在UserVO里面，并插在数据库里面
        //3：创建语句：
        try {
            String sql="insert into T_User values(?,?)";//预编译：通过占位符
            PreparedStatement pst=con.prepareStatement(sql);//这里是没有执行的
            pst.setString(1,user.getUsername());
            pst.setString(2,user.getPassword());//准备
            int rows=pst.executeUpdate();//这里不用将sql放进去了，因为预定义的时候，就已经放进去了
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
            //出现异常一般返回的是-1
            return -1;
        }
    }
    public static void main(String[] args) {
        UserVO user=new UserVO();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        UserDAO dao=new UserDAO();//new对象的时候就已经创建连接了
        if(dao.save(user)==1){
            System.out.println("保存到DB成功了");
        }else {
            System.out.println("保存到DB失败了");
        }
    }
}
