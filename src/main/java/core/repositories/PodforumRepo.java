package core.repositories;

import core.entites.Podforum;

import java.util.List;

public interface PodforumRepo {

        public List<Podforum> findAllPodforums();
        public Podforum findPodforum(Long id);
        public Podforum findPodforumByName(String naziv);
        public Podforum createPodforum(Podforum data);

}
