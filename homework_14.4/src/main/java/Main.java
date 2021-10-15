import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    private static String query;

    public static void main(String[] args) {

        query = "INSERT INTO LinkedPurchaseList (studentId, courseId, price, subscriptionDate) " +
                        "SELECT student.id, course.id, course.price, subscription.subscriptionDate " +
                        "FROM Course course " +
                        "INNER JOIN Subscription subscription ON subscription.subscriptionKey.courseId = course.id " +
                        "INNER JOIN Student student ON student.id = subscription.subscriptionKey.studentId";

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(registry)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery(query).executeUpdate();
        System.out.println("Table OK!");

        transaction.commit();

    }
}
