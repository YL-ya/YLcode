package frank.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//删除文章，支持多个文章删除：
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //因为是从URL中获取到的ids；ids=1,2,3所以我们要装成Int数组
        String idsString=req.getParameter("ids");

        int[]ids=parseIds(idsString);
        //int数组，传到数据库中将对应的ids的进行删除即可

        return null;
    }

    //字符串转成int类型的数组
    public static int[]parseIds(String idsString){//1,2,3
        String[] idsArray=idsString.split(",");//{"1","2","3"}
        int[]ids=new int[idsArray.length];
        for (int i = 0; i <idsArray.length ; i++) {
            ids[i]=Integer.parseInt(idsArray[i]);//{1,2,3}
        }
        return ids;
    }
}
