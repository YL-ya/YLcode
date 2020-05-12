package frank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//定义一个返回的处理类；因为前端代码里面的有些字段后端返回的json格式是没有的，前端无法进行判断
@Getter
@Setter
@ToString
public class Result {
    //该实体类里面的属性就是我们前端依赖的属性，可以进行判断的
    private boolean success;

    private String message;//存放错误信息

    private String stackTrace;

    private Object data;//存放后端的json数据

    //json数据放进data，把success设置成true，如果出现异常，将异常信息放进message


}
