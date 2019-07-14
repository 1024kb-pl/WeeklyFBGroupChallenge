package weather.api;

import org.springframework.web.client.RestTemplate;
import weather.model.Weather;
import weather.model.WeatherAssembler;
import weather.model.WeatherMeasurement;

import java.time.OffsetDateTime;

public class WeatherService {
    private static final String REST_API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String APP_ID = "03255fea2ddb591a710d106574e66116";

    private final WeatherRestApiService weatherRestApiService;
    private final WeatherAssembler weatherAssembler;

    public WeatherService() {
        this.weatherRestApiService = new WeatherRestApiService(REST_API_URL, APP_ID, new RestTemplate());
        this.weatherAssembler = new WeatherAssembler();
    }

    public WeatherMeasurement getWeatherForCity(String name) {
        Weather weatherForCity = weatherRestApiService.getWeatherForCity(name);

        return weatherAssembler.convertToMeasurement(OffsetDateTime.now(), weatherForCity);
    }
}

