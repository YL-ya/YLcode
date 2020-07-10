package yl.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//测试返回数据的格式：json
/*
* http请求返回的响应的统一格式
* 具体需要字段，是前后端约定好的，不谈写错的话，前端解析会出现问题*/
@Getter
@Setter
@ToString
public class ResponseResult {

    private boolean success;//前端响应的状态码为200，但是success可以false
    private String code;//自定义的消息编码
    private String message;//自定义的消息内容
    private Integer total;//用来分页，所需要的字段，查询总的行数(不是分页的数量)
    private Object data;//业务数据
    private String stackTrace;//出现异常的堆栈信息
}
