package pl.blog.java.weeklychallenge;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Tag tag1 = new Tag(1L, "qweqw");
        User author = new User(1L, "qwe", "qwe@wp.pl");
        Comment comment = new Comment(1L,  "comment", OffsetDateTime.now(), author);
        Category category = new Category(1L, "kategoria");
        List<Comment> comments = new LinkedList<>();
        comments.add(comment);
        List<Tag> tags = Arrays.asList(tag1);

        Article article = new Article(
                "ID", "TYTUL", "META DESC", "CONTENT", author,
                comments, tags, Collections.emptyList(), category);

        System.out.println(article.toString());

        comments.remove(0);
        article.getTags().add(new Tag(2L, "NEW TAG"));
        System.out.println(article.toString());

    }
}
