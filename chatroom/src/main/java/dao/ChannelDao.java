package dao;

import model.Channel;
import model.DBUtil;
import util.ChatroomException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//围绕着频道进行操作的逻辑
public class ChannelDao {
    //1:新增频道
    public void add(Channel channel){
        //1:获取数据库连接
        Connection connection= DBUtil.getConnection();
        //2:拼接sql语句
        String sql="insert into channel values(null,?)";
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,channel.getChannelName());
            //3:执行sql语句
            int ret=statement.executeUpdate();
            if(ret!=1){
                throw new ChatroomException("插入频道失败");
            }
            System.out.println("插入频道成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ChatroomException("插入频道失败");
        }finally {
            //4:释放连接
            DBUtil.close(connection,statement,null);
        }
    }
    //2:删除频道
    public void delete(int channelId){
        //1:获取数据库连接
        Connection connection= DBUtil.getConnection();
        //2:拼接sql语句
        String sql="delete from channel where channelId=?";
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,channelId);
            //3:执行sql语句
            int ret=statement.executeUpdate();
            if(ret!=1){
                throw new ChatroomException("删除频道失败");
            }
            System.out.println("删除频道成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ChatroomException("删除频道失败");
        }finally {
            //4:释放连接
            DBUtil.close(connection,statement,null);
        }
    }
    //3:查看频道列表
    public List<Channel> selectAll(){
        List<Channel> channels=new ArrayList<>();
        //1:获取连接
        Connection connection=DBUtil.getConnection();
        //2:拼接sql语句
        String sql="select * from channel";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            statement=connection.prepareStatement(sql);
            //3:执行sql
            resultSet=statement.executeQuery();
            //4:遍历结果集合
            while(resultSet.next()){
                Channel channel=new Channel();
                channel.setChannelId(resultSet.getInt("channelId"));
                channel.setChannelName(resultSet.getString("channelName"));
                channels.add(channel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ChatroomException("查看频道列表失败");
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return channels;
    }
    //按理说，还应该实现，指定用户关注某个频道/取消关注某个频道

}
