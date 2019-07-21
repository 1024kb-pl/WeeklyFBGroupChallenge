package pl.blog.java.weeklychallenge;

import java.time.OffsetDateTime;

class Comment {
    public Long id;
    public String content;
    public OffsetDateTime createdDate;
    public User author;

    public Comment(Long id, String content, OffsetDateTime createdDate, User author) {
        this.id = id;
        this.content = content;
        this.createdDate = createdDate;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
