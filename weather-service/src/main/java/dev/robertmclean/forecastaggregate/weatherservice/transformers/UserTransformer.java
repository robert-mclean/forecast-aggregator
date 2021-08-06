package dev.robertmclean.forecastaggregate.weatherservice.transformers;

import dev.robertmclean.forecastaggregate.weatherservice.dtos.UserDto;
import dev.robertmclean.forecastaggregate.weatherservice.entities.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.List;

@Component
public class UserTransformer {
    public List<User> entitiesFromDtos(List<UserDto> dtos) {
        return dtos.stream()
                .map(dto -> User
                        .builder()
                        .id(dto.getId())
                        .latitude(dto.getLatitude())
                        .longitude(dto.getLongitude())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public List<UserDto> dtosFromEntities(List<User> entities) {
        return entities.stream()
                .map(entity -> UserDto
                        .builder()
                        .id(entity.getId())
                        .latitude(entity.getLatitude())
                        .longitude(entity.getLongitude())
                        .build()
                )
                .collect(Collectors.toList());
    }
}