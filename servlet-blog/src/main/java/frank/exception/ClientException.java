package frank.exception;
//客户端异常
public class ClientException extends BaseException{
    //如果不写构造方法的话，子类会调用父类的无参构造方法，但是父类中没有写无参构造,报错

    public ClientException(String code, String message) {
        this(code, message,null);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("CLI"+code, "客户端异常"+message, cause);
    }

/*
    public ClientException(String code) {
        this(code,null);
    }

    public ClientException(String code, String message) {
       this(code, message,null);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("CLI"+code, "客户端异常"+message, cause);
    }*/
}
