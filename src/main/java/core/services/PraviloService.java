package core.services;

import core.entites.Pravilo;
import core.services.util.PraviloList;

import java.util.List;

public interface PraviloService {
    public PraviloList findAllPravilos();
    public Pravilo findPravilo(Long id);
    public Pravilo findPraviloByName(String nazivPravila);
    public Pravilo createPravilo(Pravilo data);
}
