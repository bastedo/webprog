package core.services.impl;

import core.entites.Account;
import core.entites.Podforum;
import core.repositories.AccountRepo;
import core.repositories.PodforumRepo;
import core.services.PodforumService;
import core.services.exceptions.PodforumExistsException;
import core.services.util.PodforumList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PodforumServiceImpl implements PodforumService {

    @Autowired
    private PodforumRepo podforumRepo ;


    @Override
    public PodforumList findAllPodforums() {
        return new PodforumList(podforumRepo.findAllPodforums());
    }

    @Override
    public Podforum findPodforum(Long id) {
        return podforumRepo.findPodforum(id);
    }

    @Override
    public Podforum findPodforumByName(String naziv) {
        return podforumRepo.findPodforumByName(naziv);
    }

    @Override
    public Podforum createPodforum(Podforum data) {
        Podforum podforum = podforumRepo.findPodforumByName(data.getNaziv());
        if (podforum != null) {
            throw new PodforumExistsException();
        }
        return podforumRepo.createPodforum(data);
    }

    @Override
    public Account findAccount(long id) {
        return new Account();
    }
}
