package weather.api;

import weather.model.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class WeatherRestApiService {
    private final String restAPIUrl;
    private final String appID;
    private final RestTemplate restTemplate;

    WeatherRestApiService(String restAPIUrl, String appID, RestTemplate restTemplate) {
        this.restAPIUrl = restAPIUrl;
        this.appID = appID;
        this.restTemplate = restTemplate;
    }

    Weather getWeatherForCity(String name) {
        ResponseEntity<Weather> weather = restTemplate.getForEntity(buildRequestURL(name), Weather.class);
        if (weather.getStatusCode().is4xxClientError()) {
            throw new RuntimeException("Can't find weather for city: " + name);
        }

        return weather.getBody();
    }

    private String buildRequestURL(String requestParam) {
        return restAPIUrl + "?appid=" + appID + "&q=" + requestParam;
    }
}
