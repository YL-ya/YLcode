package com.bitedu.db;

import com.bitedu.data.Student;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOperation {
    private static String URL=
            "jdbc:mysql://localhost/course_system";
    private static String USER="root";
    private static String PASSWORD = "";

    public static DataSource getDataSource(){
        MysqlDataSource dataSource =
                new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }
    // 1. 插入学生表
    public static void insertStudent(Student stu)
    {
        // 1. 获取数据源
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = getDataSource().
                    getConnection();

            String sql =
                    "insert into student(sn,name,classid) values(?,?,?)";
            pstmt = connection.prepareStatement(sql);

            System.out.println(pstmt);
            System.out.println(stu);

            pstmt.setInt(1, stu.getSn());
            pstmt.setString(2, stu.getName());
            pstmt.setInt(3,stu.getClassId());
            pstmt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null){
                    pstmt.close();
                }
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    // 2. 查询学生表
    public static Student selectStudent(int sn)
    {
        // 1. 获取数据源
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = new Student();
        try {
            connection = getDataSource().
                    getConnection();

            String sql =
                    "select * from student where sn = ?";
            pstmt = connection.prepareStatement(sql);

            System.out.println(pstmt);
            pstmt.setInt(1, sn);

            rs = pstmt.executeQuery();

            while (rs.next()){
                student.setSn(rs.getInt("sn"));
                student.setName(rs.getString("name"));
                student.setClassId(rs.getInt("classId"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null){
                    pstmt.close();
                }
                if (connection != null){
                    connection.close();
                }
                try {
                    if(rs!=null){
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return student;
    }

    // 3. 插入班级表
    // 4. 查询班级表

    // 插入课程表
    // 查询课程表

    // 插入教师表
    // 查询教师表

    // 插入 take
    // 查询 take

    // 插入 teach
    // 查询 teach
}