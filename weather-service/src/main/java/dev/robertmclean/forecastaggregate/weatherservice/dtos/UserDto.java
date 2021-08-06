package dev.robertmclean.forecastaggregate.weatherservice.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private long id;
    private double latitude;
    private double longitude;
}