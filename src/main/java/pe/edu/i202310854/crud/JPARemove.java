package pe.edu.i202310854.crud;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202310854.entity.Country;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Country country = em.find(Country.class, "IMG");
        if (country != null) {
            em.remove(country);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
