package yl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="yl.mapper")//加载包并进行扫描,生成接口的代理类
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
