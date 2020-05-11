package frank.model;
//将用户和文章的表转成java的实体类；因为java语言是面向对象编程的
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//因为java就是现象对象变成的
import java.util.Date;
@Getter
@Setter
@ToString//插件，注解就不用在重写方法了，代码看起来比较整洁
public class User {
    private Integer id;
    private String name;
    //java中是驼峰式；而数据库是_（下划线）java.util.Date;
    private Date createTime;
}
