package core.repositories.jpa;

import core.entites.Account;
import core.entites.Podforum;
import core.entites.Zalba;
import core.repositories.ZalbaRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaZalbaRepo implements ZalbaRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Zalba> findAllZalbas() {
        Query query = em.createQuery("SELECT z FROM Zalba z");
        return query.getResultList();
    }

    @Override
    public Zalba findZalba(Long id) {
        return  em.find(Zalba.class, id);
    }

    @Override
    public List<Zalba> findPraviloByModerator(Account account) {
        Query query = em.createQuery("SELECT z FROM Zalba z WHERE z.odgovorniModerator=?1");
        query.setParameter(1, account);
        return query.getResultList();
    }


    @Override
    public Zalba createZalba(Zalba data) {
        em.persist(data);
        return data;
    }
}
