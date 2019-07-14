package pl.blog;

import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {

        // How to avoid this ugly following record? How it can be done better?
        Issue issue = new Issue("Loading screen error", "client@mail.com", IssueType.BUG, Priority.HIGH, OffsetDateTime.now(), IssueStatus.WAITING);
        issue.setComponent(Component.MOBILE_APP);
        issue.setDescription("I can't use mobile application");
        issue.setAssigneeEmail("support@mail.com");

    }
}
