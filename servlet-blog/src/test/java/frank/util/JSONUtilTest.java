package frank.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import frank.model.Article;
import org.junit.Test;

import java.util.Date;

//测试：json：可以将对象转化成Json格式;用Json的框架将对象转化成字符串；也就是将对象进行格式化
public class JSONUtilTest {
    @Test
    public void t1(){
        try {
            ObjectMapper mapper=new ObjectMapper();
            Article article=new Article();
            article.setId(1);
            article.setTitle("好帅哦");
            article.setContent("计算机大法真是好，让人秃头，又费脑");
            article.setUserId(1);
            article.setCreateTime(new Date());

            //1:序列化：将对象变Json格式（json数据格式：是键值对那样的：字符串
            String s=mapper.writeValueAsString(article);
            System.out.println(s);

            //2:反序列化：将json字符串反序列化为对象
            Article des=mapper.readValue(s,Article.class);
            System.out.println(des);//这里打印的是Article类自己生成的ToString打印出来的
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
