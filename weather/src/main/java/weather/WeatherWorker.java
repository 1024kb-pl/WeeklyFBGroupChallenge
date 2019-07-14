package weather;

import weather.api.WeatherService;
import weather.model.WeatherMeasurement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

class WeatherWorker implements Runnable {
    private final WeatherService weatherService;
    private final String fileOfNameForLogs;
    private final String cityName;

    WeatherWorker(WeatherService weatherService, String fileOfNameForLogs, String cityName) {
        this.weatherService = weatherService;
        this.fileOfNameForLogs = fileOfNameForLogs;
        this.cityName = cityName;

        onInit();
    }

    private void onInit() {
        String message = createInitialMessage();
        saveMessageToFile(message);
    }

    private String createInitialMessage() {
        WeatherMeasurement weather = weatherService.getWeatherForCity(cityName);
        return cityName + " " + weather.getSunrise() + " " + weather.getSunset();
    }

    private void saveMessageToFile(String message) {
        try {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileOfNameForLogs, true));
            outputStream.println(message + "\n");
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("Can't create file: " + fileOfNameForLogs + " or it's a directory.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public void run() {
        WeatherMeasurement weatherMeasurement = weatherService.getWeatherForCity(cityName);
        saveMessageToFile(weatherMeasurement.toString());
    }
}
