package ua.goit.hw10;

import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.goit.hw10.entity.Client;
import ua.goit.hw10.entity.Planet;
import ua.goit.hw10.entity.Ticket;

@Data
public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    static {
        INSTANCE = new HibernateUtil();
    }
    private final SessionFactory sessionFactory;

    public HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
