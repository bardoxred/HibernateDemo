import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        try {

            Student student1 = new Student("Konrad", "Wesołowski", "wesolowski@wp.pl");
            Student student2 = new Student("Arek", "Pawlak", "pawlak@wp.pl");
            Student student3 = new Student("Stefan", "Gortad", "gortad@wp.pl");
            Student student4 = new Student("Ala", "Mala", "mala@wp.pl");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(student1);
            entityManager.persist(student2);
            entityManager.persist(student3);
            entityManager.persist(student4);
            System.out.println("Saving...");
            entityManager.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            entityManagerFactory.close();
        }

    }
}
