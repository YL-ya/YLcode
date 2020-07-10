package yl.servlet;

import yl.exception.BaseException;
import yl.model.ResponseResult;
import yl.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ResponseResult r=new ResponseResult();


        try {
            Object data=process(req,resp);//父类的services调用doGet/doPost方法，执行到这里，调用子类的process方法
            //只要process没有抛出异常，就返回成功的数据
            r.setSuccess(true);
            r.setCode("200");//设置返回数据的字段
            r.setMessage("操作成功");
            r.setData(data);
        } catch (Exception e) {//process抛异常的处理逻辑
            e.printStackTrace();
            if(e instanceof BaseException){
                BaseException be=(BaseException) e;
                r.setCode(be.getCode());
                r.setMessage(be.getMessage());
            }else {
                r.setCode("500");
                r.setMessage("未知错误");
            }
            //设置堆栈信息：
            StringWriter sw=new StringWriter();
            PrintWriter pw=new PrintWriter(sw);
            e.printStackTrace(pw);
            r.setStackTrace(sw.toString());
        }
        PrintWriter pw=resp.getWriter();
        pw.print(JSONUtil.write(r));
        pw.flush();
    }

    //子类重写此抽象方法
    public abstract Object process(HttpServletRequest req,HttpServletResponse resp)
            throws Exception;
}
