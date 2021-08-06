package dev.robertmclean.forecastaggregate.weatherservice.entities;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id private long id;
    @NonNull private double latitude;
    @NonNull private double longitude;
}