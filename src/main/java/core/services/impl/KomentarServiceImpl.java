package core.services.impl;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Podforum;
import core.entites.Tema;
import core.repositories.KomentarRepo;
import core.services.KomentarService;
import core.services.util.KomentarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class KomentarServiceImpl implements KomentarService {

    @Autowired
    private KomentarRepo komentarRepo;
    
    
    @Override
    public KomentarList findAllKomentars() {
        return new KomentarList(komentarRepo.findAllKomentars());
    }

    @Override
    public Komentar findKomentar(Long id) {
        return komentarRepo.findKomentar(id);
    }

    @Override
    public KomentarList findKomentarByAutor(Account account) {
        return new KomentarList(komentarRepo.findKomentarByAutor(account));
    }

    @Override
    public KomentarList findKomentarByPodforum(Podforum podforum) {
        return new KomentarList(komentarRepo.findKomentarByPodforum(podforum));
    }

    @Override
    public KomentarList findKomentarByRKomentar(Komentar komentar) {
        return new KomentarList(komentarRepo.findKomentarByRKomentar(komentar));
    }

    @Override
    public KomentarList findKomentarByTema(Tema tema) {
        return new KomentarList(komentarRepo.findKomentarByTema(tema));
    }

    @Override
    public Komentar createKomentar(Komentar data) {
        return komentarRepo.createKomentar(data);
    }
}
