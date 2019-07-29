package pl.blog.java;

public class CalendarValidationService {
    private static final int MAX_NUMBER_OF_USER_CALENDARS = 5;
    private static final int MAX_NUMBER_OF_GLOBAL_CALENDARS = 50;
    private static final int MAX_NUMBER_OF_PROJECT_CALENDARS = 30;
    private final CalendarDAO calendarDAO;

    public CalendarValidationService(CalendarDAO calendarDAO) {
        this.calendarDAO = calendarDAO;
    }

    public void validate(Calendar calendar) {
        switch (calendar.getScope()) {
            case USER:
                validateUserCalendar(calendar);
                return;
            case PROJECT:
                validateProjectCalendar(calendar);
                return;
            case GLOBAL:
                validateGlobalCalendar(calendar);
                return;
        }

        throw new IllegalArgumentException("Validation method for calendar scope: " + calendar.getScope() + " is not defined.");
    }

    private void validateProjectCalendar(Calendar calendar) {
        int countOfProjectCalendars = calendarDAO.getProjectCalendars().size();

        if (countOfProjectCalendars > MAX_NUMBER_OF_PROJECT_CALENDARS) {
            throw new RuntimeException("Limit of project calendars is reached.");
        }
    }

    private void validateGlobalCalendar(Calendar calendar) {
        int countOfGlobalCalendars = calendarDAO.getGlobalCalendars().size();

        if (countOfGlobalCalendars > MAX_NUMBER_OF_GLOBAL_CALENDARS) {
            throw new RuntimeException("Limit of global calendars is reached.");
        }
    }

    private void validateUserCalendar(Calendar calendar) {
        int countOfUserCalendars = calendarDAO.getUserCalendars().size();

        if (countOfUserCalendars > MAX_NUMBER_OF_USER_CALENDARS) {
            throw new RuntimeException("Limit of user calendars is reached.");
        }
    }
}
