package core.services.util;

import core.entites.Poruka;

import java.util.ArrayList;
import java.util.List;

public class PorukaList {

    private List<Poruka> poruka = new ArrayList<Poruka>();

    public PorukaList(List<Poruka> list) {
        this.poruka = list;
    }

    public List<Poruka> getPorukas() {
        return poruka;
    }

    public void setPorukas(List<Poruka> accounts) {
        this.poruka = accounts;
    }
}