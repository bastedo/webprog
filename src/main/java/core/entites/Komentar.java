package core.entites;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "komentar")
public class Komentar {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "tekst_komentara")
    private String tekstKomentara;

    @Column(name = "broj_pozitivnih_glasova")
    private Integer brojPozitivnihGlasova;

    @Column(name = "broj_negativnih_glasova")
    private Integer brojNegativnihGlasova;

    @Column(name = "komentar_izmenjen")
    private Boolean komentarIzmenjen;

    @Column(name = "komentar_lizbrisan")
    private Boolean komentarLIzbrisan;

    @ManyToOne
    private Account korisnik;

    @ManyToOne
    private Tema pripadaTemi;

    @ManyToOne
    private Komentar roditeljskiKomentar;

    @ManyToOne
    private Podforum pripadaPodforumu;

    public Podforum getPripadaPodforumu() {
        return pripadaPodforumu;
    }

    public void setPripadaPodforumu(Podforum pripadaPodforumu) {
        this.pripadaPodforumu = pripadaPodforumu;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
