package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private final static SimpleDateFormat isoDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private final static Pattern pattern = Pattern.compile("(\\d{2}[/.-]\\d{2}[/.-]\\d{4})");

    private List<Date> extractDates(String input) {
        Matcher group = pattern.matcher(input);

        List<Date> dates = new LinkedList<>();

        while (group.find()) {
            String date = group.group();
            System.out.println(date);
            date = date.replace("/", "-");
            date = date.replace(".", "-");

            try {
                dates.add(isoDateFormat.parse(date));
            } catch (ParseException e) {
                System.err.println("Couldn't parse: " + date + " to format: " + isoDateFormat);
            }
        }

        return dates;
    }
    public static void main(String[] args) {
	    String input = "W dniu 10-08-2018 rozpoczęto prace remontowe przy ulicy Kościuszki. Według umów prace mają potrwać do dnia 25/11/2018, jeśli firmie nie uda się wykonać zaplanowanej pracy do ustalonego terminu zapłacą wysokie kary. Kary wzrosną, gdy prace nie będą wykonane do dnia 01.01.2019 roku.";

        System.out.println(new Main().extractDates(input).stream().map(isoDateFormat::format).collect(Collectors.toList()));
    }
}
