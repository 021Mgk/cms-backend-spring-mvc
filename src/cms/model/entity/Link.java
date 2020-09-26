package cms.model.entity;


import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity(name = "link")
@Table(name="link")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String link;
    private int place;
    private int order_;
    private String icon;

    @Column(columnDefinition = "int", length = 1)
    private boolean active;


    public Link() {

    }

    public Link(String title, String link, int place, int order, String icon, boolean isActive) {
        this.title = title;
        this.link = link;
        this.place = place;
        this.order_ = order;
        this.icon = icon;
        this.active = isActive;
    }

    public Long getId() {
        return id;
    }

    public Link setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Link setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Link setLink(String link) {
        this.link = link;
        return this;
    }

    public int getPlace() {
        return place;
    }

    public Link setPlace(int place) {
        this.place = place;
        return this;
    }

    public int getOrder() {
        return order_;
    }

    public Link setOrder(int order) {
        this.order_ = order;
        return this;
    }

    public String getIcon() {
        return  icon;
    }

    public Link setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Link setActive(boolean active) {
        this.active = active;
        return this;
    }
}
