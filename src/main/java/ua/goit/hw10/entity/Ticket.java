package ua.goit.hw10.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ticket {

    private Integer id;

    private LocalDateTime createdAt;

    private Client client;

    private Planet fromPlanet;

    private Planet toPlanet;


}
