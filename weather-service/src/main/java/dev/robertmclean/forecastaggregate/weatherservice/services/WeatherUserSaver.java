package dev.robertmclean.forecastaggregate.weatherservice.services;

import dev.robertmclean.forecastaggregate.weatherservice.entities.User;

import java.util.List;

public interface WeatherUserSaver {

    List<User> save(List<User> users);

}