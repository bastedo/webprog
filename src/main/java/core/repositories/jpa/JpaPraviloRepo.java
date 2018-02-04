package core.repositories.jpa;

import core.entites.Pravilo;
import core.repositories.PraviloRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaPraviloRepo implements PraviloRepo{

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Pravilo> findAllPravilos() {
        Query query = em.createQuery("SELECT c FROM Pravilo c");
        return query.getResultList();
    }

    @Override
    public Pravilo findPravilo(Long id) {
        return  em.find(Pravilo.class, id);
    }

    @Override
    public Pravilo findPraviloByName(String nazivPravila) {
        Query query = em.createQuery("SELECT c FROM Pravilo c WHERE c.nazivPravila=?1");
        query.setParameter(1, nazivPravila);
        List<Pravilo> pravilos = query.getResultList();
        if(pravilos.size() == 0) {
            return null;
        } else {
            return pravilos.get(0);
        }
    }

    @Override
    public Pravilo createPravilo(Pravilo data) {
        em.persist(data);
        return data;
    }
}
