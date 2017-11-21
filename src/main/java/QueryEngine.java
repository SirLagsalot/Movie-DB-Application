import Entities.TestTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class QueryEngine {

    private static SessionFactory factory;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        try {
//            Configuration cfg = new Configuration();
//            cfg.configure("hibernate.cfg.xml");
//            factory = cfg.buildSessionFactory();
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            factory = metaData.getSessionFactoryBuilder().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Failed to create session factory");
            System.exit(1);
        }

        try (Session session = factory.openSession()) {
            Transaction t = session.beginTransaction();
            TestTable e1 = new TestTable();
            e1.setId(115);
            e1.setFirstName("foo");
            e1.setLastName("bar");
            session.persist(e1);
            t.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        factory.close();
    }

    private static final String testTable = "CREATE TABLE Test (\n" +
            "id int," +
            "foo varchar(16)" +
            ");";

    private static final String createPersonTable = "CREATE TABLE IF NOT EXISTS Person (\n" +
            "nConst VARCHAR(16) NOT NULL,\n" +
            "primaryName VARCHAR(108) NULL,\n" +
            "birthYear INT NULL,\n" +
            "deathYear INT NULL,\n" +
            "PRIMARY KEY (nConst),\n" +
            "INDEX nConst (nConst ASC));";

    private static final String createProductionTable = "CREATE TABLE IF NOT EXISTS Production (" +
            "tConst VARCHAR(16) NOT NULL," +
            "titleType VARCHAR(20) NOT NULL," +
            "primaryTitle VARCHAR(96) NULL," +
            "originalTitle VARCHAR(96) NULL," +
            "adult TINYINT(1) NULL," +
            "startYear INT NULL," +
            "endYear INT NULL," +
            "runtime FLOAT NULL," +
            "PRIMARY KEY (tConst)," +
            "INDEX tConst (tConst ASC);";

    private static final String createEpisodeTable = "CREATE TABLE IF NOT EXISTS Episode (" +
            "tConst VARCHAR(16) NOT NULL," +
            "parentTConst VARCHAR(16) NOT NULL," +
            "seasonNumber INT NULL," +
            "episodeNumber INT NULL," +
            "PRIMARY KEY (tConst)," +
            "INDEX tConst (tConst ASC)," +
            "CONSTRAINT tConstEFK FOREIGN KEY (tConst)" +
            "REFERENCES Production (tConst)" +
            "ON DELETE CASCADE ON UPDATE NO ACTION," +
            "CONSTRAINT parentTConstFK FOREIGN KEY (parentTConst)" +
            "REFERENCES Production (tConst)" +
            "ON DELETE CASCADE ON UPDATE NO ACTION);";

    private static final String createKnownForTable = "CREATE TABLE IF NOT EXISTS Known_For (" +
            "nConst VARCHAR(16) NOT NULL," +
            "title VARCHAR(45) NOT NULL," +
            "PRIMARY KEY (nConst , title)," +
            "INDEX nConst (nConst ASC)," +
            "CONSTRAINT nConstKnownForFK FOREIGN KEY (nConst)" +
            "REFERENCES Person (nConst)" +
            "ON DELETE SET NULL ON UPDATE NO ACTION);";

    private static final String createPrimaryProfessionTable = "CREATE TABLE IF NOT EXISTS Primary_Profession (" +
            "nConst VARCHAR(16) NOT NULL," +
            "profession VARCHAR(32) NOT NULL," +
            "PRIMARY KEY (nConst , profession)," +
            "INDEX nConst (nConst ASC)," +
            "CONSTRAINT nConstProfessionFK FOREIGN KEY (nConst)" +
            "REFERENCES Person (nConst)" +
            "ON DELETE SET NULL ON UPDATE NO ACTION);";

    private static final String createGenreTable = "CREATE TABLE IF NOT EXISTS Genre (" +
            "tConst VARCHAR(16) NOT NULL," +
            "genre VARCHAR(16) NOT NULL," +
            "PRIMARY KEY (tConst , genre)," +
            "INDEX tConst (tConst ASC)," +
            "CONSTRAINT tConstGenreFK FOREIGN KEY (tConst)" +
            "REFERENCES Production (tConst)" +
            "ON DELETE SET NULL ON UPDATE NO ACTION);";

    private static final String createRatingsTable = "CREATE TABLE IF NOT EXISTS Ratings (" +
            "tConst VARCHAR(16) NOT NULL," +
            "averageRating FLOAT NULL," +
            "numVotes INT NULL," +
            "PRIMARY KEY (tConst)," +
            "INDEX tConst (tConst ASC)," +
            "CONSTRAINT tConstRatingsFK FOREIGN KEY (tConst)" +
            "REFERENCES Production (tConst)" +
            "ON DELETE SET NULL ON UPDATE NO ACTION);";

    private static final String createFinancesTable = "CREATE TABLE IF NOT EXISTS Finances (" +
            "tConst VARCHAR(16) NOT NULL," +
            "budget FLOAT NULL," +
            "revenue FLOAT NULL," +
            "PRIMARY KEY (tConst)," +
            "INDEX tConst (tConst ASC)," +
            "CONSTRAINT tConstFinancesFK FOREIGN KEY (tConst)" +
            "REFERENCES Production (tConst)" +
            "ON DELETE SET NULL ON UPDATE NO ACTION);";

    private static final String createActsInTable = "CREATE TABLE IF NOT EXISTS Acts_In (" +
            "nConst VARCHAR(16) NOT NULL," +
            "tConst VARCHAR(16) NOT NULL," +
            "PRIMARY KEY (nConst , tConst)," +
            "INDEX tConst_idx (tConst ASC)," +
            "CONSTRAINT nConstActsInFK FOREIGN KEY (nConst)" +
            "REFERENCES Person (nConst)" +
            "ON DELETE NO ACTION ON UPDATE NO ACTION," +
            "CONSTRAINT tConstActsInFK FOREIGN KEY (tConst)" +
            "REFERENCES Production (tConst)" +
            "ON DELETE NO ACTION ON UPDATE NO ACTION);";

    private static final String createDirectsTable = "CREATE TABLE IF NOT EXISTS DIRECTS (" +
            "nConst VARCHAR(16) NOT NULL," +
            "tConst VARCHAR(16) NOT NULL," +
            "PRIMARY KEY (nConst , tConst)," +
            "INDEX tConst_idx (tConst ASC)," +
            "CONSTRAINT nConstDirectsFK FOREIGN KEY (nConst)" +
            "REFERENCES Person (nConst)" +
            "ON DELETE NO ACTION ON UPDATE NO ACTION," +
            "CONSTRAINT tConstDirectsFK FOREIGN KEY (tConst)" +
            "REFERENCES Production (tConst)" +
            "ON DELETE NO ACTION ON UPDATE NO ACTION);";

    private static final String createWritesTable = "CREATE TABLE IF NOT EXISTS WRITES (" +
            "nConst VARCHAR(16) NOT NULL," +
            "tConst VARCHAR(16) NOT NULL," +
            "PRIMARY KEY (nConst , tConst)," +
            "INDEX tConst_idx (tConst ASC)," +
            "CONSTRAINT nConstWritesFK FOREIGN KEY (nConst)" +
            "REFERENCES Person (nConst)" +
            "ON DELETE NO ACTION ON UPDATE NO ACTION," +
            "CONSTRAINT tConstWritesFK FOREIGN KEY (tConst)" +
            "REFERENCES Production (tConst)" +
            "ON DELETE NO ACTION ON UPDATE NO ACTION);";
}
