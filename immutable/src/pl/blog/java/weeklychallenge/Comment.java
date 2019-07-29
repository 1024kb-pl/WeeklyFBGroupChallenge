package pl.blog.java.weeklychallenge;

import java.time.OffsetDateTime;

class Comment {
    private Long id;
    private String content;
    private OffsetDateTime createdDate;
    private User author;

    public Comment(Long id, String content, OffsetDateTime createdDate, User author) {
        this.id = id;
        this.content = content;
        this.createdDate = createdDate;
        this.author = new User(author);
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public User getAuthor() {
        return new User(author);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", author=" + author +
                '}';
    }
}
