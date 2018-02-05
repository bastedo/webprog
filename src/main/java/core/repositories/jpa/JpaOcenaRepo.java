package core.repositories.jpa;


import core.entites.Account;
import core.entites.Komentar;
import core.entites.Ocena;
import core.entites.Tema;
import core.repositories.OcenaRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaOcenaRepo implements OcenaRepo{

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Ocena> findAllOcenas() {
        Query query = em.createQuery("SELECT c FROM Ocena c");
        return query.getResultList();
    }

    @Override
    public Ocena findOcena(Long id) {
        return  em.find(Ocena.class, id);
    }

    @Override
    public List<Ocena> findOcenaByAccount(Account account) {
        Query query = em.createQuery("SELECT c FROM Poruka c WHERE c.account=?1");
        query.setParameter(1, account);
        return query.getResultList();
    }

    @Override
    public List<Ocena> findOcenaByKomentar(Komentar komentar) {
        Query query = em.createQuery("SELECT c FROM Poruka c WHERE c.komentar=?1");
        query.setParameter(1, komentar);
        return query.getResultList();
    }

    @Override
    public List<Ocena> findOcenaByTema(Tema tema) {
        Query query = em.createQuery("SELECT c FROM Poruka c WHERE c.tema=?1");
        query.setParameter(1, tema);
        return query.getResultList();
    }


    @Override
    public Ocena createOcena(Ocena data) {
        em.persist(data);
        return data;
    }

    @Override
    public Ocena findOcenaByOcena(Ocena data) {
        Query query = em.createQuery("SELECT c FROM Poruka c WHERE c.tema=?1 AND c.account=?2 AND c.komentar=?3 ");
        query.setParameter(1, data.getTema());
        query.setParameter(2, data.getAccount());
        query.setParameter(3, data.getKomentar());
        List<Ocena> ocenas = query.getResultList();
        if(ocenas.size() == 0) {
            return null;
        } else {
            return ocenas.get(0);
        }
    }
}
