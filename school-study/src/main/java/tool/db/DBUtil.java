package tool.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//这个是用连进行连接数据库的类
public class DBUtil {
    private static Connection con=null;
    public static Connection getConnection(){
        String driverClass ="com.mysql.jdbc.Diver";
        String url="jdbc:mysql://localhost:3306/school";
        String username="root";
        String password="123";
        try {
            //1：加载驱动：
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(con==null){
            //2：建立连接
            try {
                con= DriverManager.getConnection(url,username,password);
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("数据库连接失败");
            }
        }
        return con;
    }
}
