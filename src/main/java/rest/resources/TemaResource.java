package rest.resources;

import core.entites.Account;
import core.entites.Podforum;
import core.entites.Tema;
import core.enumeration.Tip;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.time.LocalDate;

public class TemaResource extends ResourceSupport {

    private String naslov;

    private String opis;

    private Tip tip;

    private String tekstualniSadrzaj;

    private byte[] slika;

    private String slikaContentType;

    private LocalDate datumKreiranja;

    private Integer brojPozitivnihGlasova;

    private Integer brojNegativnihGlasova;

    private Account autor;

    private Podforum pripadaPodforumu;

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public String getTekstualniSadrzaj() {
        return tekstualniSadrzaj;
    }

    public void setTekstualniSadrzaj(String tekstualniSadrzaj) {
        this.tekstualniSadrzaj = tekstualniSadrzaj;
    }

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
    }

    public String getSlikaContentType() {
        return slikaContentType;
    }

    public void setSlikaContentType(String slikaContentType) {
        this.slikaContentType = slikaContentType;
    }

    public LocalDate getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(LocalDate datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Integer getBrojPozitivnihGlasova() {
        return brojPozitivnihGlasova;
    }

    public void setBrojPozitivnihGlasova(Integer brojPozitivnihGlasova) {
        this.brojPozitivnihGlasova = brojPozitivnihGlasova;
    }

    public Integer getBrojNegativnihGlasova() {
        return brojNegativnihGlasova;
    }

    public void setBrojNegativnihGlasova(Integer brojNegativnihGlasova) {
        this.brojNegativnihGlasova = brojNegativnihGlasova;
    }

    public Account getAutor() {
        return autor;
    }

    public void setAutor(Account autor) {
        this.autor = autor;
    }

    public Podforum getPripadaPodforumu() {
        return pripadaPodforumu;
    }

    public void setPripadaPodforumu(Podforum pripadaPodforumu) {
        this.pripadaPodforumu = pripadaPodforumu;
    }

    public Tema toTema () {
        Tema tema = new Tema() ;
        tema.setAutor(autor);
        tema.setBrojNegativnihGlasova(brojNegativnihGlasova);
        tema.setBrojPozitivnihGlasova(brojPozitivnihGlasova);
        tema.setNaslov(naslov);
        tema.setDatumKreiranja(datumKreiranja);
        tema.setOpis(opis);
        tema.setPripadaPodforumu(pripadaPodforumu);
        tema.setSlika(slika);
        tema.setSlikaContentType(slikaContentType);
        tema.setTekstualniSadrzaj(tekstualniSadrzaj);
        tema.setTip(tip);
        return tema ;
    }
}
