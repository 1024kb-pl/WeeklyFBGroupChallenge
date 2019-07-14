import weather.WeatherWorkerService;

public class WeatherApp {
    public static void main(String[] args) {
        WeatherWorkerService workerService = new WeatherWorkerService();

        workerService.startWorkerForCity("Lodz");
        workerService.startWorkerForCity("Warsaw");
        workerService.startWorkerForCity("London");
        workerService.startWorkerForCity("Wroclaw");
    }
}
