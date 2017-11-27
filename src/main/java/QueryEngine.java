import Entities.Production;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class QueryEngine {

    private static SessionFactory factory;

    public static void main(String[] args) {
        configureSessionFactory();

        try (Session session = factory.openSession()) {
            Query query = crewDiedBeforeRelease(session);

            List<Production> list = (List<Production>) query.list();

            for (Production person : list) {
                System.out.println(person.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        factory.close();
    }

    private static Query crewDiedBeforeRelease(Session session) {
        return session.createQuery("FROM Entities.Production");

//        return session.createQuery("SELECT primaryTitle p1, primaryTitle p2 " +
//                "FROM Entities.Production as p1, Entities.Production as p2 " +
//                "WHERE p1 !=  LIKE 'p2.primaryTitle%'");
    }

    private static Query sequels(Session session) {
        return session.createQuery("from Entities.Production " +
                "WHERE primaryTitle LIKE '% 2'\n" +
                "   OR primaryTitle LIKE '% two'\n").setMaxResults(1000);
    }

    private static String partOf = "Entities.Person ";

    private static void configureSessionFactory() {
        try {
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            StandardServiceRegistry registry = builder.configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(registry).getMetadataBuilder().build();
            factory = metaData.getSessionFactoryBuilder().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}
