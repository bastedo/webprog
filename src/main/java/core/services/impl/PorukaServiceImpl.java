package core.services.impl;

import core.entites.Account;
import core.entites.Poruka;
import core.repositories.PorukaRepo;
import core.services.PorukaService;
import core.services.util.PorukaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PorukaServiceImpl implements PorukaService {

    @Autowired
    private PorukaRepo porukaRepo ;


    @Override
    public PorukaList findAllPorukas() {
        return new PorukaList(porukaRepo.findAllPorukas());
    }

    @Override
    public Poruka findPoruka(Long id) {
        return porukaRepo.findPoruka(id);
    }

    @Override
    public PorukaList findPorukaByPosiljalac(Account account) {
        return new PorukaList(porukaRepo.findPorukaByPosiljalac(account));
    }

    @Override
    public PorukaList findPorukaByPrimalac(Account account) {
        return new PorukaList(porukaRepo.findPorukaByPrimalac(account));
    }

    @Override
    public Poruka createPoruka(Poruka data) {
        return porukaRepo.createPoruka(data);
    }
}
