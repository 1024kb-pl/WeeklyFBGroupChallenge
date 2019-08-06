package pl.blog.java.validation;

import pl.blog.java.Calendar;
import pl.blog.java.CalendarDAO;
import pl.blog.java.Scope;

public class UserCalendarValidator extends AbstractCalendarValidator {
    private static final int MAX_NUMBER_OF_USER_CALENDARS = 5;

    public UserCalendarValidator(CalendarDAO calendarDAO) {
        super(calendarDAO);
    }

    @Override
    public void validate(Calendar calendar) {
        int countOfUserCalendars = calendarDAO.getUserCalendars().size();

        if (countOfUserCalendars > MAX_NUMBER_OF_USER_CALENDARS) {
            throw new RuntimeException("Limit of user calendars is reached.");
        }
    }

    @Override
    Scope getScope() {
        return Scope.USER;
    }
}
