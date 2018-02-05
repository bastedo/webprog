package core.services.impl;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Ocena;
import core.entites.Tema;
import core.repositories.OcenaRepo;
import core.services.OcenaService;
import core.services.exceptions.OcenaExistsException;
import core.services.util.OcenaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OcenaServiceImpl implements OcenaService {
    @Autowired
    private OcenaRepo ocenaRepo ;


    @Override
    public OcenaList findAllOcenas() {
        return new OcenaList(ocenaRepo.findAllOcenas());
    }

    @Override
    public Ocena findOcena(Long id) {
        return ocenaRepo.findOcena(id);
    }

    @Override
    public OcenaList findOcenaByAccount(Account account) {
        return new OcenaList(ocenaRepo.findOcenaByAccount(account));
    }

    @Override
    public OcenaList findOcenaByKomentar(Komentar komentar) {
        return new OcenaList(ocenaRepo.findOcenaByKomentar(komentar));
    }

    @Override
    public OcenaList findOcenaByTema(Tema tema) {
        return new OcenaList(ocenaRepo.findOcenaByTema(tema));
    }


    @Override
    public Ocena createOcena(Ocena data) {
        Ocena ocena = ocenaRepo.findOcenaByOcena(data);
        if (ocena != null) {
            throw new OcenaExistsException();
        }
        return ocenaRepo.createOcena(data);
    }
}