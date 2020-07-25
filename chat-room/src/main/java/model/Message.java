package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Setter
@Getter
@ToString
public class Message {
    private int messageId;
    private int userId;
    private int channelId;
    private String context;
    private Timestamp sendTime;

    //在此处新加一个字段：此处的nickName就和userId是对应的
    //直接把用户的昵称放在这里的，方便后面的界面显示

    //通过userId里面(用户表)可以得到nickname
    private String nickName;
}
