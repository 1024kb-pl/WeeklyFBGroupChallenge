package pl.blog.java;

import pl.blog.java.validation.CalendarValidationService;

import java.util.UUID;

public class CalendarMetadataService {
    private final CalendarDAO calendarDAO;
    private final CalendarValidationService calendarValidationService;

    public CalendarMetadataService(CalendarDAO calendarDAO,
                                   CalendarValidationService calendarValidationService) {
        this.calendarDAO = calendarDAO;
        this.calendarValidationService = calendarValidationService;
    }

    public void addCalendar(Calendar calendar) {
        calendarValidationService.validate(calendar);

        calendar.setUUID(UUID.randomUUID().toString());

        calendarDAO.saveCalendar(calendar);
    }
}
