package core.repositories.jpa;

import core.entites.Account;
import core.entites.Podforum;
import core.entites.Tema;
import core.repositories.TemaRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaTemaRepo implements TemaRepo {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Tema> findAllTemas() {
        Query query = em.createQuery("SELECT t FROM Tema t");
        return query.getResultList();
    }

    @Override
    public Tema findTema(Long id) {
        return  em.find(Tema.class, id);
    }

    @Override
    public List<Tema> findTemaByAutor(Account account) {
        Query query = em.createQuery("SELECT t FROM Tema t WHERE t.autor=?1");
        query.setParameter(1, account);
        return query.getResultList();
    }

    @Override
    public List<Tema> findTemaByPodforum(Podforum podforum) {
        Query query = em.createQuery("SELECT t FROM Tema t WHERE t.pripadaPodforumu=?1");
        query.setParameter(1, podforum);
        return query.getResultList();
    }

    @Override
    public Tema createTema(Tema data) {
        em.persist(data);
        return data;
    }
}
