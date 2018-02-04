package core.entites;

import core.enumeration.Tip;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tema")

public class Tema {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "naslov", nullable = false)
    private String naslov;


    @Column(name = "opis", nullable = false)
    private String opis;

    @Enumerated(EnumType.STRING)
    @Column(name = "tip")
    private Tip tip;

    @Lob
    @Column(name = "tekstualni_sadrzaj")
    private String tekstualniSadrzaj;

    @Lob
    @Column(name = "slika")
    private byte[] slika;

    @Column(name = "slika_content_type")
    private String slikaContentType;


    @Column(name = "datum_kreiranja")
    private LocalDate datumKreiranja;

    @Column(name = "broj_pozitivnih_glasova")
    private Integer brojPozitivnihGlasova;

    @Column(name = "broj_negativnih_glasova")
    private Integer brojNegativnihGlasova;

    @ManyToOne
    private Account autor;


    @ManyToOne
    private Podforum pripadaPodforumu;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}