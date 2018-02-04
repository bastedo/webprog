package rest.resources;

import core.entites.Account;
import core.entites.Zalba;
import core.enumeration.StatusZalbe;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;

public class ZalbaResource  extends ResourceSupport {

    private String tekstZalbe;


    private LocalDate datumZalbe;

    private StatusZalbe regulisana;


    private Account autor;

    private Account odgovorniModerator;

    public String getTekstZalbe() {
        return tekstZalbe;
    }

    public void setTekstZalbe(String tekstZalbe) {
        this.tekstZalbe = tekstZalbe;
    }

    public LocalDate getDatumZalbe() {
        return datumZalbe;
    }

    public void setDatumZalbe(LocalDate datumZalbe) {
        this.datumZalbe = datumZalbe;
    }

    public StatusZalbe getRegulisana() {
        return regulisana;
    }

    public void setRegulisana(StatusZalbe regulisana) {
        this.regulisana = regulisana;
    }

    public Account getAutor() {
        return autor;
    }

    public void setAutor(Account autor) {
        this.autor = autor;
    }

    public Account getOdgovorniModerator() {
        return odgovorniModerator;
    }

    public void setOdgovorniModerator(Account odgovorniModerator) {
        this.odgovorniModerator = odgovorniModerator;
    }

    public Zalba toZalba () {
        Zalba zalba = new Zalba();
        zalba.setAutor(autor);
        zalba.setDatumZalbe(datumZalbe);
        zalba.setTekstZalbe(tekstZalbe);
        zalba.setRegulisana(regulisana);
        zalba.setOdgovorniModerator(odgovorniModerator);
        return zalba ;

    }
}
