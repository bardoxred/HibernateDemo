
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UpdateStudentDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            int studentId = 1;
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class, studentId);
            System.out.println("Updating student...");
            student.setFirstName("Scooby");

            entityManager.getTransaction().commit();

            //Another example
            entityManager.getTransaction().begin();
            System.out.println("Updating email for all students");
            entityManager.createQuery("update Student set email='wow.@wp.pl' where firstName = 'Konrad'").executeUpdate();
            entityManager.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            entityManagerFactory.close();
        }

    }
}
