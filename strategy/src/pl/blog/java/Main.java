package pl.blog.java;

import java.time.OffsetDateTime;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        CalendarDAO dao = new CalendarDAO();
        CalendarMetadataService metadataService = new CalendarMetadataService(dao, new CalendarValidationService(dao));

        Calendar calendar = new Calendar("Kalendarz", Scope.USER, Collections.singletonList(OffsetDateTime.now()));

        metadataService.addCalendar(calendar);


        Calendar newCalendar = new Calendar("ANY Calendar name", Scope.GROUP, Collections.singletonList(OffsetDateTime.now()));
        Calendar teamCalendar = new Calendar("ANY Calendar name", Scope.TEAM, Collections.singletonList(OffsetDateTime.now()));

        metadataService.addCalendar(newCalendar);
        metadataService.addCalendar(teamCalendar);
    }
}
