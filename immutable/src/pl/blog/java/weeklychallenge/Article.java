package pl.blog.java.weeklychallenge;

import java.util.List;

class Article {
    public String id;
    public String title;
    public String metaDescription;
    public String content;
    public User author;
    public List<Comment> comments;
    public List<Tag> tags;
    public List<Article> linkedArticles;
    public Category category;

    public Article(String id, String title, String metaDescription, String content, User author, List<Comment> comments, List<Tag> tags, List<Article> linkedArticles, Category category) {
        this.id = id;
        this.title = title;
        this.metaDescription = metaDescription;
        this.content = content;
        this.author = author;
        this.comments = comments;
        this.tags = tags;
        this.linkedArticles = linkedArticles;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Article> getLinkedArticles() {
        return linkedArticles;
    }

    public void setLinkedArticles(List<Article> linkedArticles) {
        this.linkedArticles = linkedArticles;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
