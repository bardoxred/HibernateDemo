
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CreateStudentDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        try {

            Student student1 = new Student();
            student1.setId(1);
            student1.setFirstName("Konrad");
            student1.setLastName("Wesolowski");
            student1.setEmail("wesolowski@wp.pl");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(student1);
            System.out.println("Saving...");
            entityManager.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            entityManagerFactory.close();
        }

    }
}
