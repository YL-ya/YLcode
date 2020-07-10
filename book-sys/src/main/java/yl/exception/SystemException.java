package yl.exception;

//客户端异常类
public class SystemException extends BaseException{

    public SystemException(String code, String message) {
        super("SYS"+code, "系统异常"+message);
    }

    public SystemException(String code, String message, Throwable cause) {
        super("SYS"+code, "系统异常"+message, cause);
    }
}
