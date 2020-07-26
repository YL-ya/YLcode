package dao;

import model.DBUtil;
import model.Message;
import util.ChatroomException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//把发送的消息给保存起来，为了实现历史消息功能
//把用户上次下线时间点到下次上线这个时间点，这两个时间间隔的消息都查出来
public class MessageDao {
    //1：新增消息
    public void add(Message message){
        //1:获取连接：
        Connection connection= DBUtil.getConnection();
        //2:拼接sql
        String sql="insert into message values(null, ?, ?, ?, ?)";
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,message.getUserId());
            statement.setInt(2,message.getChannelId());
            statement.setString(3,message.getContent());
            statement.setTimestamp(4,message.getSendTime());
            //3：执行sql
            int ret=statement.executeUpdate();
            if(ret!=1){
                throw new ChatroomException("插入消息失败");
            }
            System.out.println("插入消息成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ChatroomException("插入消息失败");
        }finally {
            //4：释放连接
            DBUtil.close(connection,statement,null);
        }
    }
    //2：按时间段查询消息
    public List<Message> selectByTimeStamp(Timestamp from,Timestamp to){
        List<Message>messages=new ArrayList<>();
        //1:获取连接：
        Connection connection=DBUtil.getConnection();
        //2:拼接sql
        //mysql中datetime类型是可以直接比较大小的
        String sql="select * from message where sendTime>= ? and sendTime<= ?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setTimestamp(1,from);
            statement.setTimestamp(2,to);
            System.out.println("selectByTimeStamp:"+statement);
            //3:执行sql
            resultSet=statement.executeQuery();
            //4:遍历结果集
            while (resultSet.next()){
                Message message=new Message();
                message.setMessageId(resultSet.getInt("messageId"));
                message.setUserId(resultSet.getInt("userId"));
                message.setChannelId(resultSet.getInt("channelId"));
                message.setContent(resultSet.getString("content"));
                message.setSendTime(resultSet.getTimestamp("sendTime"));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5：释放连接
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    //进行简单的单元测试
    public static void main(String[] args) {
        MessageDao messageDao=new MessageDao();
        //1:创建消息
        Message message=new Message();
        message.setUserId(1);
        message.setChannelId(1);
        message.setContent("hello");
        //在java中构造一个TimeStamp对象构造方法的参数的，就是构造一个毫秒级别的时间戳
        message.setSendTime(new Timestamp(System.currentTimeMillis()));
    }
}
