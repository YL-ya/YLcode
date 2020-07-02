package yl.service;

import org.springframework.stereotype.Service;
import yl.mapper.ArticleMapper;
import yl.model.Article;

import javax.annotation.Resource;
import java.util.List;

@Service
//表示注入到容器中
public class ArticleService {

    @Resource
    //装配接口，生成代理类
    private ArticleMapper articleMapper;//注入接口

    public Article queryById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public List<Article> queryByUserId(Integer userId) {
        return articleMapper.queryByUserId(userId);
    }
}
