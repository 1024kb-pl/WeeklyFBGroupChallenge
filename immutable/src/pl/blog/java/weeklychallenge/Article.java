package pl.blog.java.weeklychallenge;

import java.util.LinkedList;
import java.util.List;

class Article {
    private String id;
    private String title;
    private String metaDescription;
    private String content;
    private User author;
    private List<Comment> comments;
    private List<Tag> tags;
    private List<Article> linkedArticles;
    private Category category;

    public Article(String id, String title, String metaDescription,
                   String content, User author, List<Comment> comments,
                   List<Tag> tags, List<Article> linkedArticles, Category category) {
        this.id = id;
        this.title = title;
        this.metaDescription = metaDescription;
        this.content = content;
        this.author = new User(author);
        this.comments = new LinkedList<>(comments);
        this.tags = new LinkedList<>(tags);
        this.linkedArticles = new LinkedList<>(linkedArticles);
        this.category = new Category(category);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return new LinkedList<>(comments);
    }

    public List<Tag> getTags() {
        return new LinkedList<>(tags);
    }

    public List<Article> getLinkedArticles() {
        return new LinkedList<>(linkedArticles);
    }

    public Category getCategory() {
        return new Category(category);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", metaDescription='" + metaDescription + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", comments=" + comments +
                ", tags=" + tags +
                ", linkedArticles=" + linkedArticles +
                ", category=" + category +
                '}';
    }
}
