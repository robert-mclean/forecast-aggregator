package dev.robertmclean.forecastaggregate.weatherservice.controllers;

import dev.robertmclean.forecastaggregate.weatherservice.dtos.UserDto;
import dev.robertmclean.forecastaggregate.weatherservice.entities.User;
import dev.robertmclean.forecastaggregate.weatherservice.services.WeatherRetriever;
import dev.robertmclean.forecastaggregate.weatherservice.services.WeatherUserLoader;
import dev.robertmclean.forecastaggregate.weatherservice.services.WeatherUserSaver;
import dev.robertmclean.forecastaggregate.weatherservice.transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class WeatherServiceController {
    @Autowired
    private UserTransformer userTransformer;
    @Autowired
    private WeatherUserSaver weatherUserSaver;
    @Autowired
    private WeatherUserLoader weatherUserLoader;
    @Autowired
    private WeatherRetriever weatherRetriever;

    @RequestMapping(
        value = "/users",
        method = RequestMethod.POST,
        produces = "application/json"
    )
    @ResponseBody
    public List<UserDto> createUsers(@RequestBody List<UserDto> userDtos) {
        List<User> users = userTransformer.entitiesFromDtos(userDtos);

        List<User> entities = weatherUserSaver.save(users);

        return userTransformer.dtosFromEntities(entities);
    }

    @RequestMapping(
        value = "/users/{userId}",
        method=RequestMethod.GET,
        produces = "application/json"
    )
    @ResponseBody
    public UserDto retrieveUser(@PathVariable Long userId) {
        List<Long> userIds = new ArrayList<Long>();
        userIds.add(userId);

        List<User> entities = weatherUserLoader.load(userIds);

        return userTransformer.dtosFromEntities(entities).get(0);
    }

    @RequestMapping(
        value = "/forecast/{userId}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    @ResponseBody
    public String retrieveForecast(@PathVariable Long userId) {
        List<Long> userIds = new ArrayList<Long>();
        userIds.add(userId);

        User user = weatherUserLoader.load(userIds).get(0);

        return weatherRetriever.retrieve(user);
    }
}