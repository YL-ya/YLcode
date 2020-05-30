package frank.model;
//将用户和文章的表转成java的实体类；因为java语言是面向对象编程的
import java.util.Date;

//因为java就是现象对象变成的
public class User {
    private Integer id;
    private String name;
    //java中是驼峰式；而数据库是_（下划线）java.util.Date;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
