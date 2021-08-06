package dev.robertmclean.forecastaggregate.weatherservice.services;

import dev.robertmclean.forecastaggregate.weatherservice.entities.User;

import java.util.List;

public interface WeatherUserLoader {

    List<User> load(List<Long> ids);

}