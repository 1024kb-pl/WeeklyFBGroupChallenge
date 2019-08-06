package pl.blog.java.validation;

import pl.blog.java.Calendar;
import pl.blog.java.CalendarDAO;
import pl.blog.java.Scope;

public abstract class AbstractCalendarValidator {
    protected final CalendarDAO calendarDAO;

    protected AbstractCalendarValidator(CalendarDAO calendarDAO) {
        this.calendarDAO = calendarDAO;
    }

    abstract void validate(Calendar calendar);
    abstract Scope getScope();
}
