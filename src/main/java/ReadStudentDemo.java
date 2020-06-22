
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ReadStudentDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            System.out.println("Getting student id");
            entityManager.getTransaction().begin();
            Student myStudent = entityManager.find(Student.class, 2);
            System.out.println(myStudent);
            entityManager.getTransaction().commit();



            System.out.println("Done!");

        } finally {
            entityManagerFactory.close();
        }

    }
}
