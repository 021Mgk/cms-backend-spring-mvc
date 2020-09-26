package cms.controller;


import cms.model.common.Uploader;
import cms.model.entity.Article;
import cms.model.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping("/articles")
    public List<Article> getArticles() {
        List<Article> articles = articleService.findAll();
        return articles;
    }


    @RequestMapping("/articles/{Id}")
    public Article findById(@PathVariable("Id") String articleId) {
        Article article = new Article();
        Article art = articleService.findOne(article, Long.parseLong(articleId));
        return art;
    }


//    @RequestMapping(value = "/articles", method = RequestMethod.POST )
//     public void saveArticle(@RequestBody Article article) {
//        articleService.save(article);
//    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public void saveArticle(
                            @ModelAttribute Article article) {
        // input name != file name
        try {
//            String covName = cov.getOriginalFilename();
//            Uploader.saveFile(cov.getInputStream(), covName);
//            article.setCover(covName);
//
//            String thuName = thu.getOriginalFilename();
//            Uploader.saveFile(thu.getInputStream(), thuName);
//            article.setThumbnail(thuName);
//
//            String attName = att.getOriginalFilename();
//            Uploader.saveFile(att.getInputStream(), attName);
//            article.setAttachment(attName);
            articleService.save(article);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    @RequestMapping(value = "/articles/{Id}", method = RequestMethod.PUT)
    public void updateArticle(@ModelAttribute Article article , @PathVariable("Id") String articleId , @RequestBody Article article1) {
        System.out.println("///////////////");
        System.out.println(articleId);
        System.out.println(article.getTitle());
        System.out.println(article.getRegister_date());
        System.out.println(article.getType());
        System.out.println(" article1 " + article1.getTitle());
      //  articleService.update(article.setId(Long.parseLong(articleId)));
    }

    @RequestMapping(value = "/articles/{Id}", method = RequestMethod.DELETE)
    public void deleteArticle(@PathVariable("Id") String articleId) {
        Article article = new Article();
        article.setId(Long.parseLong(articleId));
        articleService.delete(article);
    }

}