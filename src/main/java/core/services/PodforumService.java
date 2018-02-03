package core.services;

import core.entites.Account;
import core.entites.Podforum;
import core.services.util.PodforumList;

import java.util.List;

public interface PodforumService  {
    public PodforumList findAllPodforums();
    public Podforum findPodforum(Long id);
    public Podforum findPodforumByName(String naziv);
    public Podforum createPodforum(Podforum data);

    public Account findAccount(long id);
}
