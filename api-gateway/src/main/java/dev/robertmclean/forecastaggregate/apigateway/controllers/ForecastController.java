package dev.robertmclean.forecastaggregate.apigateway.controllers;

import dev.robertmclean.forecastaggregate.apigateway.dtos.WeatherUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ForecastController {
    private final RestTemplate restTemplate;

    public ForecastController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/weatherUsers")
    public ResponseEntity<List<WeatherUserDto>> createUsers(@RequestBody List<WeatherUserDto> userDtos) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<WeatherUserDto>> requestEntity = new HttpEntity<List<WeatherUserDto>>(userDtos, headers);

        return restTemplate.exchange(
                "http://weather-service/users",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<WeatherUserDto>>() {}
        );
    }

    @GetMapping("/weatherUsers/{userId}")
    public ResponseEntity<WeatherUserDto> retrieveUser(@PathVariable Long userId) {
        return restTemplate.exchange(
                "http://weather-service/users/"+userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<WeatherUserDto>() {}
        );
    }

    @GetMapping("/weatherForecast/{userId}")
    public ResponseEntity<String> retrieveForecast(@PathVariable Long userId) {
        return restTemplate.exchange(
                "http://weather-service/forecast/"+userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {}
        );
    }
}
