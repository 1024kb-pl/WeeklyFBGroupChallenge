package pl.blog;

import java.time.OffsetDateTime;

class Issue {
    private final String summary;
    private final String description;
    private final String reporterEmail;
    private final String assigneeEmail;
    private final IssueType type;
    private final Priority priority;
    private final OffsetDateTime createdDate;
    private final IssueStatus status;
    private final Component component;

    private Issue(String summary, String description, String reporterEmail, String assigneeEmail, IssueType type, Priority priority, OffsetDateTime createdDate, IssueStatus status, Component component) {
        this.summary = summary;
        this.description = description;
        this.reporterEmail = reporterEmail;
        this.assigneeEmail = assigneeEmail;
        this.type = type;
        this.priority = priority;
        this.createdDate = createdDate;
        this.status = status;
        this.component = component;
    }

    private static class Builder implements NeedSummary, NeedCreatedDate, NeedPriority, NeedReporter, NeedType, CanBeBuild {
        private String summary;
        private String description;
        private String reporterEmail;
        private String assigneeEmail;
        private IssueType type;
        private Priority priority;
        private OffsetDateTime createdDate;
        private IssueStatus status;
        private Component component;
        
        @Override
        public NeedReporter summary(String summary) {
            this.summary = summary;
            return this;
        }

        @Override
        public NeedPriority reporter(String reporterEmail) {
            this.reporterEmail = reporterEmail;
            return this;
        }

        @Override
        public NeedCreatedDate createdDate(OffsetDateTime offsetDateTime) {
            this.createdDate = offsetDateTime;
            return this;
        }

        @Override
        public NeedType status(IssueStatus status) {
            this.status = status;
            return this;
        }

        @Override
        public CanBeBuild type(IssueType issueType) {
            this.type = issueType;
            return this;
        }

        @Override
        public CanBeBuild description(String description) {
            this.description = description;
            return this;
        }

        @Override
        public CanBeBuild assignee(String assigneeEmail) {
            this.assigneeEmail = assigneeEmail;
            return this;
        }

        @Override
        public CanBeBuild component(Component component) {
            this.component = component;
            return this;
        }

        @Override
        public Issue build() {
            return new Issue(summary, description, reporterEmail, assigneeEmail, type, priority, createdDate, status, component);
        }
    }

    static NeedSummary builder() {
        return new Builder();
    }

    interface NeedSummary {
        NeedReporter summary(String summary);
    }

    interface NeedReporter {
        NeedPriority reporter(String reporterEmail);
    }

    interface NeedPriority {
        NeedCreatedDate createdDate(OffsetDateTime offsetDateTime);
    }

    interface NeedCreatedDate {
        NeedType status(IssueStatus status);
    }

    interface NeedType {
        CanBeBuild type(IssueType issueType);
    }

    interface CanBeBuild {
        CanBeBuild description(String description);
        CanBeBuild assignee(String assigneeEmail);
        CanBeBuild component(Component component);
        Issue build();
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
