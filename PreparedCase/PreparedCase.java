package com.mysql.firstjdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
/*1·建表的时候用的是Statement语句，和sql创建表的语句是一样的
* 2·下面进行插入的时候因经常改变数据，用了占位符PreparedStatement(用？可以代表占位符)语句进行建立，
* 得到了代码的优化*/


public class PreparedCase {
    private final static String URL = "jdbc:mysql://hostname/my_jdbc_db";//字符串常量存在常量池
    private final static String USER = "root";
    private final static String PASSWORD = "";

    static {
        //文件中的先执行
    }

    public static DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        return dataSource;

    }

//建表：
    public static void createTable() {
        DataSource dataSource = getDataSource();
        Connection connection = null;
        Statement statement = null;
        try {
            //获取连接
            connection = dataSource.getConnection();

            //创建语句
            String sql = "create table student(" + "name varchar(20) not null,"
                    + "sn int primary key," + "height double(5,2))";
            System.out.println("sql="+sql);//将语句进行打印
            statement = connection.createStatement();

            //执行语句
            statement.execute(sql);//返回的是布尔类型的
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //写了一个学生类
    public static class Student{
        private String name;
        private int sn;
        private int height;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSn() {
            return sn;
        }

        public void setSn(int sn) {
            this.sn = sn;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

//插入元素：
    public static void insertTable(Student stu) {
        DataSource dataSource = getDataSource();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //获取连接
            connection = dataSource.getConnection();

            //创建语句
            String sql="insert into student values (?,?,?)";
           /* String sql = "insert into student values" +
                    "(" + "'lily'," + "20191002," + "172," + ")";*/
            //当插入改成20191003就得用到prepareStatement:占位符

            System.out.println("sql="+sql);
            statement = connection.prepareStatement(sql);

            statement.setString(1,stu.getName());//在合理就不用管在java中字符串是单引号
            statement.setInt(2,stu.getSn());
            statement.setInt(3,stu.getHeight());
            //执行语句：
            statement.execute();//PreparedStatement这里是不能给值的,Statement类型必须给值
            // 这里返回的是布尔类型的
            /*statement = connection.createStatement();
            statement.execute(sql);*///执行语句
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//表查询：
    public static void selectTable(int sn){
        DataSource dataSource = getDataSource();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs=null;
        try {
            //获取连接
            connection = dataSource.getConnection();

            //创建语句
            String sql="select * from student where sn=?";
           /* String sql = "insert into student values" +
                    "(" + "'lily'," + "20191002," + "172," + ")";*/
            //当插入改成20191003就得用到prepareStatement:占位符

            System.out.println("sql="+sql);
            statement = connection.prepareStatement(sql);

            //索引跟表的属性没有关系，只跟占位符有关，因为只有一个？,所以，就只用一个1 表示占位符即可
            //根据学号进行查询
            statement.setInt(1,sn);


            //执行语句：
            rs=statement.executeQuery();//这里是不能给值的//查询返回的是结果集
            while (rs.next()){
                System.out.println("name="+rs.getString("name")+
                ",sn="+rs.getInt("sn")+",height+"+rs.getInt("height"));
            }
            /*statement = connection.createStatement();
            statement.execute(sql);*///执行语句
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("hello main");

      //  createTable();
        //将java语言中的对象转换成表中的实体
        Student stu=new Student();
        stu.setName("lily");
        stu.setSn(20191004);
        stu.setHeight(190);
        insertTable(stu);

        selectTable(20191003);
        //selectTable("lily");


    }
}
