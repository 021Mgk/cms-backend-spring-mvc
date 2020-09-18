package cms.model.service;



import cms.model.entity.Link;
import cms.model.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LinkService {

    @Autowired
    GenericRepository<Long , Link, String> repository;

    @Transactional(rollbackFor = Exception.class)
    public void save(Link links) {
        repository.save(links);
    }


    @Transactional
    public void update(Link links) {
        repository.update(links);
    }

    @Transactional
    public void delete(Link links){
        repository.delete(links);
    }


    public List<Link> findAll() {
        return repository.findAll(Link.class);
    }


    public Link findOne(Link links, Long id) {
        return repository.findOne(links.getClass(), id);
    }


    public List<Link> findByWhere(String where) {
        return repository.findByWhere(Link.class , where);
    }

}
