import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class WeatherApiConsumer {

    public static void main(String[] args) {
        String jsonResponse = "{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],"
                + "\"base\":\"stations\",\"main\":{\"temp\":289.15,\"feels_like\":287.89,\"temp_min\":287.15,\"temp_max\":291.15,\"pressure\":1015,\"humidity\":77,\"sea_level\":1023,\"grnd_level\":1015},"
                + "\"visibility\":10000,\"wind\":{\"speed\":5.66,\"deg\":330,\"gust\":7.72},\"clouds\":{\"all\":0},\"dt\":1690492926,\"sys\":{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1690453599,\"sunset\":1690497768},"
                + "\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

        System.out.println("City: " + jsonObject.get("name").getAsString());
        System.out.println("Temperature: " + jsonObject.get("main").getAsJsonObject().get("temp").getAsDouble() + " K");
        System.out.println("Feels Like: " + jsonObject.get("main").getAsJsonObject().get("feels_like").getAsDouble() + " K");
        System.out.println("Temperature Min: " + jsonObject.get("main").getAsJsonObject().get("temp_min").getAsDouble() + " K");
        System.out.println("Temperature Max: " + jsonObject.get("main").getAsJsonObject().get("temp_max").getAsDouble() + " K");
        System.out.println("Pressure: " + jsonObject.get("main").getAsJsonObject().get("pressure").getAsInt() + " hPa");
        System.out.println("Humidity: " + jsonObject.get("main").getAsJsonObject().get("humidity").getAsInt() + " %");
        System.out.println("Sea Level: " + jsonObject.get("main").getAsJsonObject().get("sea_level").getAsInt() + " hPa");
        System.out.println("Ground Level: " + jsonObject.get("main").getAsJsonObject().get("grnd_level").getAsInt() + " hPa");
        System.out.println("Visibility: " + jsonObject.get("visibility").getAsInt() + " m");
        System.out.println("Wind Speed: " + jsonObject.get("wind").getAsJsonObject().get("speed").getAsDouble() + " m/s");
        System.out.println("Wind Degree: " + jsonObject.get("wind").getAsJsonObject().get("deg").getAsInt() + " degrees");
        System.out.println("Wind Gust: " + jsonObject.get("wind").getAsJsonObject().get("gust").getAsDouble() + " m/s");
        System.out.println("Cloud Coverage: " + jsonObject.get("clouds").getAsJsonObject().get("all").getAsInt() + " %");
        System.out.println("Sunrise: " + jsonObject.get("sys").getAsJsonObject().get("sunrise").getAsLong()); // Unix timestamp
        System.out.println("Sunset: " + jsonObject.get("sys").getAsJsonObject().get("sunset").getAsLong());   // Unix timestamp
        System.out.println("Country: " + jsonObject.get("sys").getAsJsonObject().get("country").getAsString());
    }
}