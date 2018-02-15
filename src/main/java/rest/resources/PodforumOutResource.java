package rest.resources;

import core.entites.Account;
import core.entites.Podforum;
import core.entites.Pravilo;
import org.springframework.hateoas.ResourceSupport;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class PodforumResource extends ResourceSupport {

    private String naziv;

    private String opis;

    private byte[] ikonica;

    private String ikonicaContentType;

    private Account odgovorniModerator;

    private Account autor ;

    private Set<Pravilo> spisakPravilas = new HashSet<>();

    public byte[] getIkonica() {
        return ikonica;
    }

    public void setIkonica(byte[] ikonica) {
        this.ikonica = (ikonica == null) ? null : ikonica.clone();
    }

    public Set<Pravilo> getSpisakPravilas() {
        return spisakPravilas;
    }

    public void setSpisakPravilas(Set<Pravilo> spisakPravilas) {
        this.spisakPravilas.addAll(spisakPravilas);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

      public String getIkonicaContentType() {
        return ikonicaContentType;
    }

    public void setIkonicaContentType(String ikonicaContentType) {
        this.ikonicaContentType = ikonicaContentType;
    }

    public Account getOdgovorniModerator() {
        return odgovorniModerator;
    }

    public void setOdgovorniModerator(Account odgovorniModerator) {
        this.odgovorniModerator = odgovorniModerator;
    }

    public Account getAutor() {
        return autor;
    }

    public void setAutor(Account autor) {
        this.autor = autor;
    }
    public Podforum toPodforum() {
        Podforum podforum = new Podforum();
        podforum.setOpis(opis);
        podforum.setOdgovorniModerator(odgovorniModerator);
        podforum.setNaziv(naziv);
        podforum.setIkonicaContentType(ikonicaContentType);
        podforum.setAutor(autor);
        podforum.setSpisakPravilas(spisakPravilas);
        return podforum ;
    }

    @Override
    public String toString() {
        return "PodforumResource{" +
                "naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", ikonicaContentType='" + ikonicaContentType + '\'' +
                ", OdgovorniModerator=" + odgovorniModerator +
                ", autor=" + autor +
                '}';
    }
}
