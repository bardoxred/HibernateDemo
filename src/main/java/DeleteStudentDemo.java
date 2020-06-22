
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DeleteStudentDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            int studentId = 2;
            entityManager.getTransaction().begin();
            System.out.println("Getting student with id:" + studentId);
            Student student = entityManager.find(Student.class, studentId);

            //delete the student
            System.out.println("removing student" + student);
            entityManager.remove(student);

            //another example

            System.out.println("removing student id=3");
            entityManager.createQuery("delete from Student where id=3").executeUpdate();

            entityManager.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            entityManagerFactory.close();
        }

    }
}
