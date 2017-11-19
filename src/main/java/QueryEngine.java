import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class QueryEngine {

    private static SessionFactory factory;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            factory = metaData.getSessionFactoryBuilder().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Failed to create session factory");
            System.exit(1);
        }

        try (Session session = factory.openSession()) {
            session.createQuery(createPersonTable);
//            System.out.println("");
//            Stream result = session.createQuery(createPersonTable).getResultStream();
//
//            List<String> stringResults = (List<String>) result.collect(Collectors.toList());
//
//            for (Entity entity : stringResults) {
//                System.out.println(entity.toString());
//                System.out.println("");
//            }
//            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        factory.close();
    }

    private static String createPersonTable = "CREATE TABLE IF NOT EXISTS PERSON (" +
            "nConst VARCHAR(16) NOT NULL," +
            "primaryName VARCHAR(108) NULL," +
            "birthYear INT NULL," +
            "deathYear INT NULL," +
            "PRIMARY KEY (nConst)," +
            "INDEX nConst (nConst ASC)";
}
