package ru.itmo.wp.lesson8.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(indexes = @Index(columnList = "creationTime"))
public class Notice {
    @Id
    @GeneratedValue
    private long id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String content;

    @CreationTimestamp
    private Date creationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
