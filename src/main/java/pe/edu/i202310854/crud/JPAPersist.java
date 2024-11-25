package pe.edu.i202310854.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.mapping.Table;
import pe.edu.i202310854.entity.*;

import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Country country = new Country();
        country.setCode("IMG");
        country.setName("Durotar");
        country.setContinent("Europe");
        country.setRegion("Orgrimar");
        country.setSurfaceArea(12345.67);
        country.setIndepYear(2000);
        country.setPopulation(1000000);
        country.setLifeExpectancy(80.5);
        country.setGnp(50000.75);
        country.setGnpOld(48000.60);
        country.setLocalName("Durotar");
        country.setGovernmentForm("Lider Tribal");
        country.setHeadOfState("Thrall");
        country.setCapital(0);
        country.setCode2("IM");


        City city1 = new City();
        city1.setName("Orgrimar");
        city1.setDistrict("Mercaderes");
        city1.setPopulation(500000);
        city1.setCountry(country);

        City city2 = new City();
        city2.setName("Ventormenta");
        city2.setDistrict("Rasganorte");
        city2.setPopulation(300000);
        city2.setCountry(country);

        City city3 = new City();
        city3.setName("Lordaeron");
        city3.setDistrict("Minas");
        city3.setPopulation(200000);
        city3.setCountry(country);


        CountryLanguage language1 = new CountryLanguage();
        language1.setId(new CountryLanguageId("IMG", "Orco"));
        language1.setCountry(country);
        language1.setOfficial(true);
        language1.setPercentage(70.0f);

        CountryLanguage language2 = new CountryLanguage();
        language2.setId(new CountryLanguageId("IMG", "Elfico"));
        language2.setCountry(country);
        language2.setOfficial(false);
        language2.setPercentage(30.0f);

        country.setCities(Arrays.asList(city1, city2, city3));
        country.setLanguages(Arrays.asList(language1, language2));
        em.persist(country);

        em.getTransaction().commit();
        em.close();
        emf.close();

        System.out.println("EXITO");
    }
}