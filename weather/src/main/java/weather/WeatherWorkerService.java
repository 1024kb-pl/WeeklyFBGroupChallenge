package weather;

import weather.api.WeatherService;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WeatherWorkerService {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final WeatherService weatherService = new WeatherService();
    private final List<ScheduledFuture<?>> executorServices = new CopyOnWriteArrayList<>();

    public void startWorkerForCity(String city) {
        String logFileName = city + ".logs";
        WeatherWorker weatherWorker = new WeatherWorker(weatherService, logFileName, city);

        final ScheduledFuture<?> weatherWorkerHandler = scheduler.scheduleWithFixedDelay(weatherWorker, 0, 1, TimeUnit.HOURS);
        executorServices.add(weatherWorkerHandler);
    }
}
