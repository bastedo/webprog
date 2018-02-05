package core.services.util;

import core.entites.Zalba;

import java.util.ArrayList;
import java.util.List;

public class ZalbaList {
    private List<Zalba> zalba = new ArrayList<Zalba>();

    public ZalbaList(List<Zalba> list) {
        this.zalba = list;
    }

    public List<Zalba> getZalbas() {
        return zalba;
    }

    public void setZalbas(List<Zalba> zalba) {
        this.zalba = zalba;
    }
}
