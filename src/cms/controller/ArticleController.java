package cms.controller;


import cms.model.entity.Article;
import cms.model.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping("/articles")
    public List<Article> getArticles(){
        List<Article> articles = articleService.findAll();
        return  articles;
    }

    @RequestMapping("/articles/{Id}")
    public Article findById(@PathVariable("Id") String  articleId ){
        Article article = new Article();
        Article art = articleService.findOne(article , Long.parseLong(articleId));
        return  art;
    }

    @RequestMapping(value = "/articles" , method = RequestMethod.POST)
    public void saveArticle(@RequestBody Article article){
        articleService.save(article);
    }


    @RequestMapping(value = "/articles/{Id}" , method = RequestMethod.PUT)
    public void updateArticle(@PathVariable("Id") String  articleId , @RequestBody Article article ){
         articleService.update(article.setId(Long.parseLong(articleId)));
    }

    @RequestMapping(value = "/articles/{Id}" , method = RequestMethod.DELETE )
    public void deleteArticle(@PathVariable("Id") String articleId){
        Article article = new Article();
        article.setId(Long.parseLong(articleId));
        articleService.delete(article);
    }

}

