package core.services.impl;

import core.entites.Account;
import core.entites.Podforum;
import core.entites.Tema;
import core.repositories.TemaRepo;
import core.services.TemaService;
import core.services.util.TemaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TemaServiceImpl implements TemaService {

    @Autowired
    private TemaRepo temaRepo;


    @Override
    public TemaList findAllTemas() {
        return new TemaList(temaRepo.findAllTemas());
    }

    @Override
    public Tema findTema(Long id) {
        return temaRepo.findTema(id);
    }

    @Override
    public TemaList findTemaByAutor(Account account) {
        return new TemaList(temaRepo.findTemaByAutor(account));
    }

    @Override
    public TemaList findTemaByPodforum(Podforum podforum) {
        return new TemaList(temaRepo.findTemaByPodforum(podforum));
    }

    @Override
    public Tema createTema(Tema data) {
        return temaRepo.createTema(data);
    }
}
