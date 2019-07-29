package pl.blog.java;

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;

public class Calendar {
    private String UUID;
    private final String name;
    private final Scope scope;
    private final List<OffsetDateTime> dates;

    public Calendar(String name, Scope scope, List<OffsetDateTime> dates) {
        this.name = name;
        this.scope = scope;
        this.dates = new LinkedList<>(dates);
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getUUID() {
        return UUID;
    }

    public String getName() {
        return name;
    }

    public Scope getScope() {
        return scope;
    }

    public List<OffsetDateTime> getDates() {
        return new LinkedList<>(dates);
    }
}
