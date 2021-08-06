package dev.robertmclean.forecastaggregate.weatherservice.services;

import dev.robertmclean.forecastaggregate.weatherservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OpenWeatherRetriever implements WeatherRetriever {
    private final RestTemplate restTemplate;

    @Autowired
    public OpenWeatherRetriever(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String retrieve(User user) {
        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("latitude", user.getLatitude());
        uriVariables.put("longitude", user.getLongitude());
        uriVariables.put("API_KEY", "bdc222e3a3cbc5b4abec90ec40866f0a");

        String uri = "https://api.openweathermap.org/data/2.5/onecall?lat={latitude}&lon={longitude}&exclude=current,minutely,daily,alerts&appid={API_KEY}&units=imperial";
        ResponseEntity<String> weatherResponse = restTemplate
                .getForEntity(uri, String.class, uriVariables);

        return weatherResponse.getBody();
    }
}
