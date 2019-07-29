package pl.blog.java.weeklychallenge;

class User {
    private Long id;
    private String login;
    private String email;

    public User(Long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public User(User author) {
        this(author.id, author.login, author.email);
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

