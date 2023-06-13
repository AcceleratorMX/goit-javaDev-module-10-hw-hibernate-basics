package ua.goit.hw10;

import ua.goit.hw10.crudServices.ClientCrudService;
import ua.goit.hw10.crudServices.PlanetCrudService;
import ua.goit.hw10.entity.Client;
import ua.goit.hw10.entity.Planet;
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
    }
}