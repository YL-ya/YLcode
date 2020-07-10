package yl.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BorrowRecord {
    private Integer id;
    private Integer bookId;
    private Integer studentId;
    private Date startTime;
    private Date endTime;
    private Date createTime;

    //根据前端信息响应字段(数据格式)进行添加属性
    private Book book;
    private Classes classes;
    private Student student;
}
