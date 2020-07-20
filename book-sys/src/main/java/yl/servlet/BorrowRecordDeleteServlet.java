package yl.servlet;

import yl.dao.BorrowRecordDAO;
import yl.exception.BusinessException;
import yl.model.BorrowRecord;
import yl.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrowRecord/delete")
public class BorrowRecordDeleteServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] ids=req.getParameterValues("ids");//因为这里是get请求方法；ids=4,ids=5
        int num= BorrowRecordDAO.delete(ids);
        if(num!=ids.length ){
            //说明没有插入成功，报异常信息
            throw new BusinessException("000010","删除图书借阅信息出错");
        }
        return null;
    }
}
