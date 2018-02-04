package core.services.util;

import core.entites.Tema;

import java.util.ArrayList;
import java.util.List;

public class TemaList {
    private List<Tema> temas = new ArrayList<Tema>();

    public TemaList(List<Tema> temas) {
        this.temas = temas;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
}
