package yl.servlet;

import yl.dao.BorrowRecordDAO;
import yl.exception.BusinessException;
import yl.model.BorrowRecord;
import yl.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrowRecord/update")
public class BorrowRecordUpdateServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //因为插入是根据客户端发过来的json格式数据，所以用流进行操作
        BorrowRecord record= JSONUtil.read(req.getInputStream(),BorrowRecord.class);
        int num= BorrowRecordDAO.update(record);
        if(num!=1){
            //说明没有插入成功，报异常信息
            throw new BusinessException("000009","修改图书借阅信息出错");
        }
        return null;
    }
}
