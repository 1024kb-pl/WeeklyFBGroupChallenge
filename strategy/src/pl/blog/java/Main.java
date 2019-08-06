package pl.blog.java;

import pl.blog.java.validation.*;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CalendarDAO dao = new CalendarDAO();
        List<AbstractCalendarValidator> validators = Arrays.asList(
                new GlobalCalendarValidator(dao),
                new ProjectCalendarValidator(dao),
                new UserCalendarValidator(dao)
        );
        CalendarMetadataService metadataService = new CalendarMetadataService(dao, new CalendarValidationService(validators));

        Calendar calendar = new Calendar("Kalendarz", Scope.USER, Collections.singletonList(OffsetDateTime.now()));

        metadataService.addCalendar(calendar);


        Calendar newCalendar = new Calendar("ANY Calendar name", Scope.GROUP, Collections.singletonList(OffsetDateTime.now()));
        Calendar teamCalendar = new Calendar("ANY Calendar name", Scope.TEAM, Collections.singletonList(OffsetDateTime.now()));

        metadataService.addCalendar(newCalendar);
        metadataService.addCalendar(teamCalendar);
    }
}
