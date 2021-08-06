package dev.robertmclean.forecastaggregate.weatherservice.daos;

import dev.robertmclean.forecastaggregate.weatherservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}