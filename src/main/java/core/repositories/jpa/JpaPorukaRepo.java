package core.repositories.jpa;

import core.entites.Account;
import core.entites.Poruka;
import core.repositories.PorukaRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaPorukaRepo implements PorukaRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Poruka> findAllPorukas() {
        Query query = em.createQuery("SELECT d FROM Poruka d");
        return query.getResultList();
    }

    @Override
    public Poruka findPoruka(Long id) {
        return  em.find(Poruka.class, id);
    }

    @Override
    public List<Poruka> findPorukaByPosiljalac(Account account) {
        Query query = em.createQuery("SELECT c FROM Poruka c WHERE c.posiljalac=?1");
        query.setParameter(1, account);
        return query.getResultList();

    }

    @Override
    public List<Poruka> findPorukaByPrimalac(Account account) {
        Query query = em.createQuery("SELECT c FROM Poruka c WHERE c.primalac=?1");
        query.setParameter(1, account);
        return query.getResultList();

    }

    @Override
    public Poruka createPoruka(Poruka data) {
        em.persist(data);
        return data;
    }
}
