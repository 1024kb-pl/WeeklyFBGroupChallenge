package pl.blog;

import java.time.OffsetDateTime;

class Issue {
    private String summary;
    private String description;
    private String reporterEmail;
    private String assigneeEmail;
    private IssueType type;
    private Priority priority;
    private OffsetDateTime createdDate;
    private IssueStatus status;
    private Component component;

    Issue(String summary, String reporterEmail, IssueType type, Priority priority, OffsetDateTime createdDate, IssueStatus status) {
        this.summary = summary;
        this.reporterEmail = reporterEmail;
        this.type = type;
        this.priority = priority;
        this.createdDate = createdDate;
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssigneeEmail(String assigneeEmail) {
        this.assigneeEmail = assigneeEmail;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public String getAssigneeEmail() {
        return assigneeEmail;
    }

    public IssueType getType() {
        return type;
    }

    public Priority getPriority() {
        return priority;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public Component getComponent() {
        return component;
    }
}
