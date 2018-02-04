package core.services.impl;

import core.entites.Pravilo;
import core.repositories.PraviloRepo;
import core.services.PraviloService;
import core.services.exceptions.PraviloExistsException;
import core.services.util.PraviloList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PraviloServiceImpl implements PraviloService {
    @Autowired
    private PraviloRepo praviloRepo ;


    @Override
    public PraviloList findAllPravilos() {
        return new PraviloList(praviloRepo.findAllPravilos());
    }

    @Override
    public Pravilo findPravilo(Long id) {
        return praviloRepo.findPravilo(id);
    }

    @Override
    public Pravilo findPraviloByName(String naziv) {
        return praviloRepo.findPraviloByName(naziv);
    }

    @Override
    public Pravilo createPravilo(Pravilo data) {
        Pravilo podforum = praviloRepo.findPraviloByName(data.getNazivPravila());
        if (podforum != null) {
            throw new PraviloExistsException();
        }
        return praviloRepo.createPravilo(data);
    }
}
