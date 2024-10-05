import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class test {
    public static void main(String[] args) {
        EntityManager en = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        en.getTransaction().begin();
        en.getTransaction().commit();
    }
}
