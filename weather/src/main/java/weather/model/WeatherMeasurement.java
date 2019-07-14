package weather.model;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class WeatherMeasurement {
    private final static String SEPARATOR = " ";
    private final OffsetDateTime measurementDate;
    private final Float temperature;
    private final Float humidity;
    private final Float pressure;
    private final Float windSpeed;
    private final OffsetTime sunrise;
    private final OffsetTime sunset;

    public WeatherMeasurement(OffsetDateTime measurementDate, Float temperature, Float humidity, Float pressure, Float windSpeed, long sunrise, long sunset) {
        this.measurementDate = measurementDate;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.sunrise = OffsetTime.ofInstant(Instant.ofEpochSecond(sunrise), ZoneId.of(ZoneOffset.UTC.getId()));
        this.sunset = OffsetTime.ofInstant(Instant.ofEpochSecond(sunset), ZoneId.of(ZoneOffset.UTC.getId()));
    }

    public String toString() {
        return measurementDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + SEPARATOR + temperature + SEPARATOR + humidity + SEPARATOR
                + pressure + SEPARATOR + windSpeed;
    }

    public OffsetTime getSunrise() {
        return sunrise;
    }

    public OffsetTime getSunset() {
        return sunset;
    }
}
