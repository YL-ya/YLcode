package yl.dao;

import yl.exception.SystemException;
import yl.model.Book;
import yl.model.BorrowRecord;
import yl.model.Classes;
import yl.model.Student;
import yl.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//图书借阅的jdbc实体类
public class BorrowRecordDAO {

    public static List<BorrowRecord> query() {
        List<BorrowRecord> records=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c=DBUtil.getConnection();
            String sql="select br.id," +
                    "       br.book_id," +
                    "       br.student_id," +
                    "       br.start_time," +
                    "       br.end_time," +
                    "       br.create_time," +
                    "       b.book_name," +
                    "       b.author," +
                    "       b.price," +
                    "       s.student_name," +
                    "       s.student_no," +
                    "       s.id_card," +
                    "       s.student_email," +
                    "       s.classes_id," +
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc" +
                    "    FROM borrow_record br" +
                    "         join book b on br.book_id = b.id" +
                    "         join student s on br.student_id = s.id" +
                    "         join classes c on s.classes_id = c.id";
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                //设置图书借阅信息
                BorrowRecord br=new BorrowRecord();
                br.setId(rs.getInt("id"));
                br.setStartTime(new Date(rs.getTimestamp("start_time").getTime()));
                br.setEndTime(new Date(rs.getTimestamp("end_time").getTime()));

                //设置图书信息：
                Book book=new Book();
                book.setId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getBigDecimal("price"));
                br.setBook(book);//最后book对象要设置到图书借阅信息属性中去

                //设置学生信息(属性)
                Student s=new Student();
                s.setId(rs.getInt("student_id"));
                s.setStudentName(rs.getString("student_name"));
                s.setStudentNo(rs.getString("student_no"));
                s.setIdCard(rs.getString("id_card"));
                s.setStudentEmail(rs.getString("student_email"));
                br.setStudent(s);

                //设置班级信息(属性)、
                Classes classes=new Classes();
                classes.setId(rs.getInt("classes_id"));
                classes.setClassesName(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getNString("classes_major"));
                classes.setClassesDesc(rs.getNString("classes_desc"));
                br.setClasses(classes);

                //将信息还要存放在list里面,返回给前端
                records.add(br);
            }

        }catch (Exception e){
            throw new SystemException("000001","查询图书借阅信息出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
        return records;
    }

    public static BorrowRecord queryById(int id) {
        BorrowRecord br=new BorrowRecord();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c=DBUtil.getConnection();
            String sql="select br.id," +
                    "       br.book_id," +
                    "       br.student_id," +
                    "       br.start_time," +
                    "       br.end_time," +
                    "       br.create_time," +
                    "       b.book_name," +
                    "       b.author," +
                    "       b.price," +
                    "       s.student_name," +
                    "       s.student_no," +
                    "       s.id_card," +
                    "       s.student_email," +
                    "       s.classes_id," +
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc" +
                    "    FROM borrow_record br" +
                    "         join book b on br.book_id = b.id" +
                    "         join student s on br.student_id = s.id" +
                    "         join classes c on s.classes_id = c.id"+
                    "    where br.id=?";
            ps=c.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                //设置图书借阅信息
                br.setId(rs.getInt("id"));
                br.setStartTime(new Date(rs.getTimestamp("start_time").getTime()));
                br.setEndTime(new Date(rs.getTimestamp("end_time").getTime()));

                //设置图书信息：
                Book book=new Book();
                book.setId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getBigDecimal("price"));
                br.setBook(book);//最后book对象要设置到图书借阅信息属性中去

                //设置学生信息(属性)
                Student s=new Student();
                s.setId(rs.getInt("student_id"));
                s.setStudentName(rs.getString("student_name"));
                s.setStudentNo(rs.getString("student_no"));
                s.setIdCard(rs.getString("id_card"));
                s.setStudentEmail(rs.getString("student_email"));
                br.setStudent(s);

                //设置班级信息(属性)、
                Classes classes=new Classes();
                classes.setId(rs.getInt("classes_id"));
                classes.setClassesName(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getNString("classes_major"));
                classes.setClassesDesc(rs.getNString("classes_desc"));
                br.setClasses(classes);
            }

        }catch (Exception e){
            throw new SystemException("000006","查询图书借阅信息详情出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
        return br;
    }

    public static int insert(BorrowRecord record) {
        //插入图书借阅信息
        Connection c=null;
        PreparedStatement ps=null;

        try {
            c=DBUtil.getConnection();
            String sql="insert borrow_record(book_id,student_id,start_time,end_time)values (?, ?, ?, ?)";
            ps=c.prepareStatement(sql);
            ps.setInt(1,record.getBookId());
            ps.setInt(2,record.getStudentId());
            ps.setTimestamp(3,new Timestamp(record.getStartTime().getTime()));
            ps.setTimestamp(4,new Timestamp(record.getEndTime().getTime()));
            return ps.executeUpdate();//直接返回的是插入的条数
        } catch (Exception e) {
            throw new SystemException("000011","插入图书借阅信息出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }

    public static int update(BorrowRecord record) {
        //更新图书查阅信息
        Connection c=null;
        PreparedStatement ps=null;

        try {
            c=DBUtil.getConnection();
            //通过id条件去修改图书借阅信息
            String sql="update borrow_record set book_id=?,student_id=?,start_time=?,end_time=? where id=?";
            ps=c.prepareStatement(sql);
            ps.setInt(1,record.getBookId());
            ps.setInt(2,record.getStudentId());
            ps.setTimestamp(3,new Timestamp(record.getStartTime().getTime()));
            ps.setTimestamp(4,new Timestamp(record.getEndTime().getTime()));
            ps.setInt(5,record.getId());
            return ps.executeUpdate();//直接返回的是插入的条数
        } catch (Exception e) {
            throw new SystemException("000012","修改图书借阅信息出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }

    public static int delete(String[] ids) {
        //删除图书借阅信息：根据ids数组进行删除
        Connection c=null;
        PreparedStatement ps=null;

        try {
            c=DBUtil.getConnection();
            StringBuilder sql=new StringBuilder("delete from borrow_record where id in (");
            for (int i = 0; i <ids.length ; i++) {
                if(i!=0){
                    sql.append(",");//除了第一个位置不加逗号
                }
                sql.append("?");
            }
            sql.append(")");

            ps=c.prepareStatement(sql.toString());

            for (int i = 0; i <ids.length ; i++) {
                ps.setInt(i+1,Integer.parseInt(ids[i]));

            }
            return ps.executeUpdate();//直接返回的是插入的条数
        } catch (Exception e) {
            throw new SystemException("000013","删除图书借阅信息出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }
}
