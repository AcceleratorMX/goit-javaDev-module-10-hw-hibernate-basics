package ua.goit.hw10.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class Ticket {

    private Integer id;

    private LocalDateTime createdAt;

    private Client client;

    private Planet fromPlanet;

    private Planet toPlanet;


}
