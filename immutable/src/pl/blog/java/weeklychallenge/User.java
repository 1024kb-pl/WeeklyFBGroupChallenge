package pl.blog.java.weeklychallenge;

class User {
    public Long id;
    public String login;
    public String email;

    public User(Long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }
}
