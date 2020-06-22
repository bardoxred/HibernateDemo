
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            List<Student> students = entityManager.createQuery("from Student").getResultList();
            displayStudents(students);
            //last name Wesolowski
            students = entityManager.createQuery("from Student s where s.lastName = 'Wesolowski'").getResultList();
            System.out.println("|---------------------------------------------------------|\nStudents who have last name of Wesolowski");
            displayStudents(students);
            System.out.println("|---------------------------------------------------------|\nStudents who have last name of Wesolowski or first name of Arek");
            //last name Wesolowski or first name Arek
            students = entityManager.createQuery("from Student s where s.lastName = 'Wesolowski' or s.firstName = 'Arek'").getResultList();
            displayStudents(students);
            System.out.println("Saving...");
            entityManager.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            entityManagerFactory.close();
        }

    }

    private static void displayStudents(List<Student> students) {
        for(Student student : students){
            System.out.println(student);
        }
    }
}
