package core.repositories.jpa;

import core.entites.Podforum;
import core.repositories.PodforumRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaPodforumRepo implements PodforumRepo {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Podforum> findAllPodforums() {
        Query query = em.createQuery("SELECT b FROM Podforum b");
        return query.getResultList();
    }

    @Override
    public Podforum findPodforum(Long id) {
        return  em.find(Podforum.class, id);
    }

    @Override
    public Podforum findPodforumByName(String naziv) {
        Query query = em.createQuery("SELECT b FROM Podforum b WHERE b.naziv=?1");
        query.setParameter(1, naziv);
        List<Podforum> accounts = query.getResultList();
        if(accounts.size() == 0) {
            return null;
        } else {
            return accounts.get(0);
        }
    }

    @Override
    public Podforum createPodforum(Podforum data) {
        em.persist(data);
        return data;
    }


}

