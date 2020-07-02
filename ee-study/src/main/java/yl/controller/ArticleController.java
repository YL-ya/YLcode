package yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yl.model.Article;
import yl.service.ArticleService;

import java.util.List;

@RestController
//传回的数据格式是json
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/query/{id}")//使用路径映射
    public Object queryById(@PathVariable("id") Integer id){
        Article article=articleService.queryById(id);
        return article;
    }

    @RequestMapping("/queryByUserId")
    public Object queryByUserId(Integer userId){
        List<Article> articles=articleService.queryByUserId(userId);
        return articles;
    }
}
