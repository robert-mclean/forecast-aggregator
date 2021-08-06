package dev.robertmclean.forecastaggregate.weatherservice.services;

import dev.robertmclean.forecastaggregate.weatherservice.daos.UserDao;
import dev.robertmclean.forecastaggregate.weatherservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherUserLoaderDB implements WeatherUserLoader {

    private final UserDao userDao;

    @Autowired
    public WeatherUserLoaderDB(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> load(List<Long> ids) {
        return userDao.findAllById(ids);
    }

}