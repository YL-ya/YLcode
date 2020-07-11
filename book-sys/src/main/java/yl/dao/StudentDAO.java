package yl.dao;

import yl.exception.SystemException;
import yl.model.Student;
import yl.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static List<Student> queryAsDict(int id) {
        List<Student> studentList=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            c=DBUtil.getConnection();
            String sql="select id,student_name,id_card,student_no from student where classes_id=?";
            ps=c.prepareStatement(sql);
            ps.setInt(1,id);//因为是根据班级id查询出学生，使用占位符
            rs=ps.executeQuery();
            while (rs.next()){
                Student student=new Student();
                student.setDictionaryTagKey(rs.getString("id"));//将id放在数据字典的字段中
                student.setDictionaryTagValue(rs.getString("student_name"));
                student.setStudentNo(rs.getString("student_no"));
                student.setIdCard(rs.getString("id_card"));
                studentList.add(student);
            }

        }catch (Exception e){
            throw new SystemException("000005","学生数据字典查询出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
        return studentList;
    }
}
