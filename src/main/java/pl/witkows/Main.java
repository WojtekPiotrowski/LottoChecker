package pl.witkows;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.witkows.models.Game;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws IOException {
        Game myGame = new Game("2", "6,7,8,9,10", LocalDateTime.now(), null);

        //Polaczenia z baza danych
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).buildMetadata();
        SessionFactory factory = metadata.buildSessionFactory();

        //Zapisanie modelu do bazy danych
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

//        session.save(myGame);
        Game gameFromDb = session.get(Game.class, "1");
        System.out.println(gameFromDb);

        transaction.commit();

        //Zamkniecie polaczenia z bazadanych
        session.close();
        factory.close();
    }
}
