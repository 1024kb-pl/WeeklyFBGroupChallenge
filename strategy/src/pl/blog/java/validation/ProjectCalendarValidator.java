package pl.blog.java.validation;

import pl.blog.java.Calendar;
import pl.blog.java.CalendarDAO;
import pl.blog.java.Scope;

public class ProjectCalendarValidator extends AbstractCalendarValidator {
    private static final int MAX_NUMBER_OF_PROJECT_CALENDARS = 30;

    public ProjectCalendarValidator(CalendarDAO calendarDAO) {
        super(calendarDAO);
    }

    @Override
    public void validate(Calendar calendar) {
        int countOfProjectCalendars = calendarDAO.getProjectCalendars().size();

        if (countOfProjectCalendars > MAX_NUMBER_OF_PROJECT_CALENDARS) {
            throw new RuntimeException("Limit of project calendars is reached.");
        }
    }

    @Override
    Scope getScope() {
        return Scope.PROJECT;
    }
}
