package dev.robertmclean.forecastaggregate.apigateway.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherUserDto {
    private long id;
    private double latitude;
    private double longitude;
}
