package cms.controller;



import cms.model.common.Uploader;
import cms.model.entity.Link;
import cms.model.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LinkController {

    @Autowired
    private LinkService linksService;


    @RequestMapping("/links")
    public List<Link> getLinks(){
        List<Link> links = linksService.findAll();
        return links;
    }


    @RequestMapping("/links/{Id}")
    public Link findById(@PathVariable("Id") String  linkId ){
        Link links = new Link();
        Link link = linksService.findOne(links , Long.parseLong(linkId));
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(link.getIcon())
                .toUriString();
        link.setIcon(fileDownloadUri);
        return link;
    }


    @RequestMapping(value = "/links" , method = RequestMethod.POST  )
    public void saveArticle(@RequestParam("file") MultipartFile file  ,  @ModelAttribute Link links){
        try {
            String fileName = file.getOriginalFilename();

            Uploader.saveFile(file.getInputStream() , fileName);
            links.setIcon(fileName);
            linksService.save(links);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/links/{Id}" , method = RequestMethod.PUT)
    public void updateArticle(@PathVariable("Id") String  linkId , @RequestBody Link links){
        linksService.update(links.setId(Long.parseLong(linkId)));
    }

    @RequestMapping(value = "/links/{Id}" , method = RequestMethod.DELETE )
    public void deleteArticle(@PathVariable("Id") String linkId){
        Link links = new Link();
        links.setId(Long.parseLong(linkId));
        linksService.delete(links);
    }


    @RequestMapping("/links/footer")
    public List<Link> getFooterLinks(){
        List<Link> links = linksService.findByWhere("o.place = 2");
        return links;
    }

    @RequestMapping("/links/header")
    public List<Link> getHeaderLinks(){
        List<Link> links = linksService.findByWhere("o.place = 1");
        return links;
    }
}
