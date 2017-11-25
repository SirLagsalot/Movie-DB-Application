import Entities.Finances;
import Entities.Person;
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
            Query query = session.createQuery("from Entities.Finances order by tConst asc").setMaxResults(100);
            List<Finances> list = (List<Finances>) query.list();

            for (Finances person : list) {
                System.out.println(person.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        factory.close();
    }

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
