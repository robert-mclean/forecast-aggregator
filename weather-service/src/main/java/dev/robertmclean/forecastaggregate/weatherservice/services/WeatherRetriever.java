package dev.robertmclean.forecastaggregate.weatherservice.services;

import dev.robertmclean.forecastaggregate.weatherservice.entities.User;

public interface WeatherRetriever {

    String retrieve(User user);

}