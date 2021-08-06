package dev.robertmclean.forecastaggregate.weatherservice.services;

import dev.robertmclean.forecastaggregate.weatherservice.daos.UserDao;
import dev.robertmclean.forecastaggregate.weatherservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherUserSaverDB implements WeatherUserSaver {

    private final UserDao userDao;

    @Autowired
    public WeatherUserSaverDB(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> save(List<User> users) {
        return userDao.saveAllAndFlush(users);
    }

}