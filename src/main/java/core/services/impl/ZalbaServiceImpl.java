package core.services.impl;

import core.entites.Account;
import core.entites.Zalba;
import core.repositories.ZalbaRepo;
import core.services.ZalbaService;
import core.services.util.ZalbaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ZalbaServiceImpl implements ZalbaService {

    @Autowired
    private ZalbaRepo zalbaRepo ;


    @Override
    public ZalbaList findAllZalbas() {
        return new ZalbaList(zalbaRepo.findAllZalbas());
    }

    @Override
    public Zalba findZalba(Long id) {
        return zalbaRepo.findZalba(id);
    }

    @Override
    public ZalbaList findPraviloByModerator(Account account) {
        return new ZalbaList(zalbaRepo.findPraviloByModerator(account));
    }


    @Override
    public Zalba createZalba(Zalba data) {
        return zalbaRepo.createZalba(data);
    }
}
