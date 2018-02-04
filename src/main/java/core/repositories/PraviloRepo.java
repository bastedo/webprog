package core.repositories;

import core.entites.Pravilo;

import java.util.List;

public interface PraviloRepo {
    public List<Pravilo> findAllPravilos();
    public Pravilo findPravilo(Long id);
    public Pravilo findPraviloByName(String nazivPravila);
    public Pravilo createPravilo(Pravilo data);
}
