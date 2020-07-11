package yl.dao;

import yl.exception.SystemException;
import yl.model.Book;
import yl.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static List<Book> queryAsDict() {
        List<Book> bookList=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            c= DBUtil.getConnection();
            String sql="select id,book_name,author,price from book";
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Book book=new Book();
                book.setDictionaryTagKey(String.valueOf(rs.getInt("id")));
                book.setDictionaryTagValue(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getBigDecimal("price"));
                bookList.add(book);
            }

        }catch (Exception e){
            throw new SystemException("000004","查询图书数据字典出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
        return bookList;
    }
}
