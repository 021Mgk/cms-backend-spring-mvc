package cms.model.service;


import cms.model.entity.Article;
import cms.model.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    GenericRepository<Long, Article ,String> repository;

    public void save(Article article) {
        repository.save(article);
    }


    public void update(Article article) {
        repository.update(article);
    }

    public void delete(Article article){
        repository.delete(article);
    }


    public List<Article> findAll() {
        return repository.findAll(Article.class);
    }


    public Article findOne(Article article, Long id) {
        return repository.findOne(article.getClass(), id);
    }


    public List<Article> findByWhere(String where) {
        return repository.findByWhere(Article.class , where);
    }

}
