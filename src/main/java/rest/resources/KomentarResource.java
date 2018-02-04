package rest.resources;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Podforum;
import core.entites.Tema;
import org.springframework.hateoas.ResourceSupport;

public class KomentarResource  extends ResourceSupport {

    private String tekstKomentara;

    private Integer brojPozitivnihGlasova;

    private Integer brojNegativnihGlasova;

    private Boolean komentarIzmenjen;

    private Account korisnik;

    private Tema pripadaTemi;

    private Komentar roditeljskiKomentar;

    private Podforum pripadaPodforumu;


    public String getTekstKomentara() {
        return tekstKomentara;
    }

    public void setTekstKomentara(String tekstKomentara) {
        this.tekstKomentara = tekstKomentara;
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

    public Boolean getKomentarIzmenjen() {
        return komentarIzmenjen;
    }

    public void setKomentarIzmenjen(Boolean komentarIzmenjen) {
        this.komentarIzmenjen = komentarIzmenjen;
    }

    public Account getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Account korisnik) {
        this.korisnik = korisnik;
    }

    public Tema getPripadaTemi() {
        return pripadaTemi;
    }

    public void setPripadaTemi(Tema pripadaTemi) {
        this.pripadaTemi = pripadaTemi;
    }

    public Komentar getRoditeljskiKomentar() {
        return roditeljskiKomentar;
    }

    public void setRoditeljskiKomentar(Komentar roditeljskiKomentar) {
        this.roditeljskiKomentar = roditeljskiKomentar;
    }

    public Podforum getPripadaPodforumu() {
        return pripadaPodforumu;
    }

    public void setPripadaPodforumu(Podforum pripadaPodforumu) {
        this.pripadaPodforumu = pripadaPodforumu;
    }

    Komentar toKomentar () {
        Komentar komentar = new Komentar();
        komentar.setBrojNegativnihGlasova(brojNegativnihGlasova);
        komentar.setBrojPozitivnihGlasova(brojPozitivnihGlasova);
        komentar.setKomentarIzmenjen(komentarIzmenjen);
        komentar.setKorisnik(korisnik);
        komentar.setPripadaPodforumu(pripadaPodforumu);
        komentar.setPripadaTemi(pripadaTemi);
        komentar.setRoditeljskiKomentar(roditeljskiKomentar);
        komentar.setTekstKomentara(tekstKomentara);

        return komentar ;
    }
}
