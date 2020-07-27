package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.ChannelDao;
import model.Channel;
import model.User;
import util.ChatroomException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//处理频道操作的api
public class ChannelServlet extends HttpServlet {
    private Gson gson=new GsonBuilder().create();
    //新增频道
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    //删除频道
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    //获取频道列表
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Channel> channels=new ArrayList<>();
        try {
            //1:验证登录状态，如果未登录则不能查看
            HttpSession httpSession=req.getSession(false);
            if(httpSession==null){
                throw new ChatroomException("您尚未登录");
            }
            User user=(User) httpSession.getAttribute("user");
            //2:查数据库
            ChannelDao channelDao=new ChannelDao();
            channels=channelDao.selectAll();
        } catch (ChatroomException e) {
            e.printStackTrace();
            //如果前面出发了异常，此时的channels将是一个空的list
            //下面的finally中将会构造出一个空数组json
        }finally {
            //3:把查询结果包装成响应内容
            //  如果参数十个list，转出的json字符串就是一个数组
            resp.setContentType("application/json;charset=utf-8");
            String jsonString =gson.toJson(channels);
            resp.getWriter().write(jsonString);
        }
    }
}
