package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

//一个User对象用来表示一条数据库的记录
//对象的属性基本和数据库的表结构一致，大部分是一致的，可能有细致上的不一样
@Getter
@Setter
@ToString
public class User {
    private int userId;
    private String name;
    private String password;
    private String nickName;
    private Timestamp lastLogout;
    //对应到mysql中的datetime类型的
}
