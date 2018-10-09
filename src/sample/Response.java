package sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private  Location coord;
    //ToDo: change ArrayList to List
    @JsonTypeInfo(use = JsonTypeInfo.Id.NONE, defaultImpl = ArrayList.class)
    private List<WeatherElem> weather;// hw - what if weather is List<WeatherElem>
    private System sys;
    private Main main;
    private Wind wind;
    private Clouds clouds;

    public Location getCoord() {
        return coord;
    }

    public void setCoord(Location coord) {
        this.coord = coord;
    }

    public List<WeatherElem> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherElem> weather) {
        this.weather = weather;
    }

    public System getSys() {
        return sys;
    }

    public void setSys(System sys) {
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

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }



    public static class Location{
       public double lon;
       public double lat;
    }
    public static class WeatherElem{
        public int id;
        public String main;
        public String description;
        public String icon;
    }
    public static class System{
        public int type;
        public int id;
        public double message;
        public String country;
        public long sunrise;
        public long sunset;
    }
    public static class Main {
        public double temp;
        public double humidity;
        public double pressure;
        public double temp_min;
        public double temp_max;
    }
    public static class Wind{
        public int speed;
        public int deg;
    }
    public static class Clouds{
        public double all;
    }
}
