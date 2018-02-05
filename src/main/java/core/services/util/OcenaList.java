package core.services.util;

import core.entites.Ocena;

import java.util.ArrayList;
import java.util.List;

public class OcenaList {

    private List<Ocena> ocena = new ArrayList<Ocena>();

    public OcenaList(List<Ocena> list) {
        this.ocena = list;
    }

    public List<Ocena> getOcenas() {
        return ocena;
    }

    public void setOcenas(List<Ocena> ocenas) {
        this.ocena = ocenas;
    }
}