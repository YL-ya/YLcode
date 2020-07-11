package yl.servlet;

import yl.dao.StudentDAO;
import yl.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//玄生数据字典查询
@WebServlet("/student/queryAsDict")
public class StudentQueryAsDictServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取班级Id
        int id=Integer.parseInt(req.getParameter("dictionaryKey"));
        List<Student> students= StudentDAO.queryAsDict(id);//查询学生的列表，
        // 作为返回值，返回给前端
        return students;
    }
}
