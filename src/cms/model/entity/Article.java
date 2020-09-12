package cms.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "article")
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date register_date;

    @NotNull(message = "لطفا نوع را انتخاب کنید")
    private int type;

    @NotNull(message = "عنوان ضروری می باشد")
    private String title;
    private String summary;
    private String text;
    private String thumbnail;
    private String cover;
    private String attachment;
    private int status;
    private Long views;


    public Article() {

    }


    public Article(Date register_date, int type, String title, String summary, String text, String thumbnail, String cover, String attachment, int status, Long views) {
        this.register_date = register_date;
        this.type = type;
        this.title = title;
        this.summary = summary;
        this.text = text;
        this.thumbnail = thumbnail;
        this.cover = cover;
        this.attachment = attachment;
        this.status = status;
        this.views = views;
    }


    public Long getId() {
        return id;
    }

    public Article setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public Article setRegister_date(Date register_date) {
        this.register_date = register_date;
        return this;
    }

    public int getType() {
        return type;
    }

    public Article setType(int type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Article setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getText() {
        return text;
    }

    public Article setText(String text) {
        this.text = text;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Article setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public Article setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public Article setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Article setStatus(int status) {
        status = status;
        return this;
    }

    public Long getViews() {
        return views;
    }

    public Article setViews(Long views) {
        this.views = views;
        return this;
    }
}
