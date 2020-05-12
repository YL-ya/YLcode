package frank.exception;

import lombok.Getter;
import lombok.Setter;

//自定义异常
@Getter
@Setter
public class BaseException extends RuntimeException{
    //子类继承该父类，就可以访问到一下属性
    protected String code;
    protected String message;

    public BaseException(String code) {
        this(code,null);//调用到了第二个构造方法
    }

    public BaseException(String code,String message ) {
        this(code,message,null);
    }

    public BaseException(String code,String message, Throwable cause ) {
        super(message, cause);
        this.code = code;
        this.message=message;
    }
}
