package core.repositories.jpa;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Podforum;
import core.entites.Tema;
import core.repositories.KomentarRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class JpaKomentarRepo implements KomentarRepo {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Komentar> findAllKomentars() {
        Query query = em.createQuery("SELECT k FROM Komentar k");
        return query.getResultList();
    }

    @Override
    public Komentar findKomentar(Long id) {
        return  em.find(Komentar.class, id);
    }

    @Override
    public List<Komentar> findKomentarByAutor(Account account) {
        Query query = em.createQuery("SELECT k FROM Komentar k WHERE k.autor=?1");
        query.setParameter(1, account);
        return query.getResultList();
    }

    @Override
    public List<Komentar> findKomentarByPodforum(Podforum podforum) {
        Query query = em.createQuery("SELECT k FROM Komentar k WHERE k.pripadaPodforumu=?1");
        query.setParameter(1, podforum);
        return query.getResultList();
    }

    @Override
    public List<Komentar> findKomentarByRKomentar(Komentar komentar) {
        Query query = em.createQuery("SELECT k FROM Komentar k WHERE k.roditeljskiKomentar=?1");
        query.setParameter(1, komentar);
        return query.getResultList();
    }

    @Override
    public Komentar createKomentar(Komentar data) {
        em.persist(data);
        return data;
    }

    @Override
    public List<Komentar> findKomentarByTema(Tema tema) {
        Query query = em.createQuery("SELECT k FROM Komentar k WHERE k.pripadaTemi=?1");
        query.setParameter(1, tema);
        return query.getResultList();
    }
}
