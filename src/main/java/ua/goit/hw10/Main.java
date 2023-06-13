package ua.goit.hw10;

import ua.goit.hw10.crudServices.ClientCrudService;
import ua.goit.hw10.crudServices.PlanetCrudService;
import ua.goit.hw10.crudServices.TicketCrudService;
import ua.goit.hw10.entity.Client;
import ua.goit.hw10.entity.Planet;
import ua.goit.hw10.entity.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        new DatabaseInitService().initDB();
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();

        // Client
        ClientCrudService clientCrudService = new ClientCrudService(hibernateUtil);

        Client client1 = new Client();
        client1.setName("Bill Gates");
        clientCrudService.addClient(client1);
        System.out.println("New client: " + client1);

        System.out.println("Get client by id: " + clientCrudService.getById(11));

        Client updateClientById = clientCrudService.getById(11);
        updateClientById.setName("Steve Jobs");
        clientCrudService.updateClient(updateClientById, 11);
        System.out.println("Change client name by id: " + clientCrudService.getById(11));

        clientCrudService.deleteById(7);

        List<Client> allClients = clientCrudService.getAllClients();
        System.out.println("All Clients:");
        for (Client client : allClients) {
            System.out.println(client);
        }
        System.out.println("\n");

        //Planet
        PlanetCrudService planetCrudService = new PlanetCrudService(hibernateUtil);

        Planet planet1 = new Planet();
        planet1.setId("URN");
        planet1.setName("Uranus");
        planetCrudService.addPlanet(planet1);
        System.out.println("New planet: " + planet1);

        System.out.println("Get planet by id: " + planetCrudService.getById("URN"));

        Planet updatePlanetById = planetCrudService.getById("URN");
        updatePlanetById.setName("Nibiru");
        planetCrudService.updatePlanet(updatePlanetById, "URN");
        System.out.println("Change planet name by id: " + planetCrudService.getById("URN"));

        planetCrudService.deleteById("URN");

        List<Planet> allPlanets = planetCrudService.getAllPlanets();
        System.out.println("All Planets");
        for (Planet planet : allPlanets) {
            System.out.println(planet);
        }
        System.out.println("\n");

        // Ticket
        TicketCrudService ticketCrudService = new TicketCrudService(hibernateUtil);

        Ticket ticket1 = new Ticket();
        ticket1.setCreatedAt(LocalDateTime.now());
        client1.setId(11);
        ticket1.setClient(client1);
        ticket1.setFromPlanet(planetCrudService.getById("ZEP")); // fromPlanet
        ticket1.setToPlanet(planetCrudService.getById("SOL")); // toPlanet
        ticketCrudService.addTicket(ticket1);
        System.out.println("New ticket: " + ticket1);

        System.out.println("Get ticket by id: " + ticketCrudService.getById(11));

        Ticket updateTicketById = ticketCrudService.getById(11);
        updateTicketById.setToPlanet(planetCrudService.getById("ELY"));
        ticketCrudService.updateTicket(updateTicketById, 11);
        System.out.println("Update ticket by id: " + ticketCrudService.getById(11));

        ticketCrudService.deleteById(11);

        List<Ticket> allTickets = ticketCrudService.getAllTickets();
        System.out.println("All Tickets");
        for (Ticket ticket : allTickets) {
            System.out.println(ticket);
        }
    }
}