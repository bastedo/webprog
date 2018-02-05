package core.services.util;

import core.entites.Pravilo;

import java.util.ArrayList;
import java.util.List;

public class PraviloList {

    private List<Pravilo> pravilo = new ArrayList<Pravilo>();

    public PraviloList(List<Pravilo> list) {
        this.pravilo = list;
    }

    public List<Pravilo> getPravilos() {
        return pravilo;
    }

    public void setPravilos(List<Pravilo> pravilos) {
        this.pravilo = pravilos;
    }
}