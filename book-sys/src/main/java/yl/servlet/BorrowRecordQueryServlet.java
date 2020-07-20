package yl.servlet;

import yl.dao.BorrowRecordDAO;
import yl.model.BorrowRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//图书信息查询接口
@WebServlet("/borrowRecord/query")
public class BorrowRecordQueryServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //实现分页：
        /*注意：
        * 1：request.getInputStream:获取输入流，指获取请求体内容，解析是依赖程序自身
        * 2：request.getParameter:可以获取k1=v1&k2=v2...这种格式的数据，可以在url中，也可以在请求体中
        * 3：GET：请求数据只能在url中
        * 4：POST：content-Type:x-www-form-urlencoded:这是默认表单的提交方式:请求体：k1=v1&k2=v2键值对
        *         content-Type:application/json:提交的请求体为json
        *         content-Type:from-data可以提交多个字段，多个文件*/

        //url中的请求数据，通过getParameter获取
        List<BorrowRecord> records= BorrowRecordDAO.query();
        return records;
    }
}
