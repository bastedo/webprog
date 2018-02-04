package rest.resources;

import core.entites.Pravilo;
import org.springframework.hateoas.ResourceSupport;

public class PraviloResource extends ResourceSupport {

    private String nazivPravila;

    private String sadrzajPravila;

    public String getNazivPravila() {
        return nazivPravila;
    }

    public void setNazivPravila(String nazivPravila) {
        this.nazivPravila = nazivPravila;
    }

    public String getSadrzajPravila() {
        return sadrzajPravila;
    }

    public void setSadrzajPravila(String sadrzajPravila) {
        this.sadrzajPravila = sadrzajPravila;
    }

    public Pravilo toPravilo() {
        Pravilo pravilo = new Pravilo();
        pravilo.setNazivPravila(nazivPravila);
        pravilo.setSadrzajPravila(sadrzajPravila);
        return pravilo ;
    }
}
