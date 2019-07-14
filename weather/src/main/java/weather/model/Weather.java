package weather.model;

public class Weather {
    private Sys sys;
    private Main main;
    private Wind wind;

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWin(Wind win) {
        this.wind = win;
    }

    public static class Sys {
        long sunrise;
        long sunset;

        public void setSunrise(long sunrise) {
            this.sunrise = sunrise;
        }

        public void setSunset(long sunset) {
            this.sunset = sunset;
        }

        public long getSunrise() {
            return sunrise;
        }

        public long getSunset() {
            return sunset;
        }
    }

    public static class Main {
        Float temp;
        Float pressure;
        Float humidity;

        public void setTemp(Float temp) {
            this.temp = temp;
        }

        public void setPressure(Float pressure) {
            this.pressure = pressure;
        }

        public void setHumidity(Float humidity) {
            this.humidity = humidity;
        }

        public Float getTemp() {
            return temp;
        }

        public Float getPressure() {
            return pressure;
        }

        public Float getHumidity() {
            return humidity;
        }
    }

    public static class Wind {
        Float speed;

        public void setSpeed(Float speed) {
            this.speed = speed;
        }

        public Float getSpeed() {
            return speed;
        }
    }
}
