package core.services.util;

import core.entites.Komentar;

import java.util.ArrayList;
import java.util.List;

public class KomentarList {

    private List<Komentar> komentars = new ArrayList<Komentar>();

    public KomentarList(List<Komentar> list) {
        this.komentars = list;
    }

    public List<Komentar> getKomentars() {
        return komentars;
    }

    public void setKomentars(List<Komentar> komentars) {
        this.komentars = komentars;
    }
}