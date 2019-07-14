package weather.model;

import java.time.OffsetDateTime;

public class WeatherAssembler {
    public WeatherMeasurement convertToMeasurement(OffsetDateTime measurementDate, Weather weather) {
        Weather.Main main = weather.getMain();
        return new WeatherMeasurement(measurementDate, main.getTemp(), main.getHumidity(), main.getPressure(), weather.getWind().getSpeed(), weather.getSys().sunrise, weather.getSys().getSunset());
    }
}

