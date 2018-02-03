package rest.resources;

import core.entites.Account;
import core.entites.Podforum;
import org.springframework.hateoas.ResourceSupport;

import java.util.Arrays;


public class PodforumResource extends ResourceSupport {

    private String naziv;

    private String opis;

    private byte[] ikonica;

    private String ikonicaContentType;

    private Account odgovorniModerator;

    private Account autor ;

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

    public byte[] getIkonica() {
        return ikonica;
    }

    public void setIkonica(byte[] ikonica) {
        this.ikonica = ikonica;
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
