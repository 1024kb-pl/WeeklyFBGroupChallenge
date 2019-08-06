package pl.blog.java.validation;

import pl.blog.java.Calendar;
import pl.blog.java.CalendarDAO;
import pl.blog.java.Scope;

public class GlobalCalendarValidator extends AbstractCalendarValidator {
    private static final int MAX_NUMBER_OF_GLOBAL_CALENDARS = 50;

    public GlobalCalendarValidator(CalendarDAO calendarDAO) {
        super(calendarDAO);
    }

    @Override
    public void validate(Calendar calendar) {
        int countOfGlobalCalendars = calendarDAO.getGlobalCalendars().size();

        if (countOfGlobalCalendars > MAX_NUMBER_OF_GLOBAL_CALENDARS) {
            throw new RuntimeException("Limit of global calendars is reached.");
        }
    }

    @Override
    Scope getScope() {
        return Scope.GLOBAL;
    }
}