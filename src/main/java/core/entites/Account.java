package core.entites;
/**
 *
 */


import core.enumeration.Uloga;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "account")

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "korisnicko_ime", nullable = false)
    private String korisnickoIme;


    @Column(name = "lozinka", nullable = false)
    private String lozinka;

    @Column(name = "ime", nullable = false)
    private String ime;

    @Column(name = "prezime", nullable = false)
    private String prezime;

    @Enumerated(EnumType.STRING)
    @Column(name = "uloga")
    private Uloga uloga;

    @Column(name = "datum_registracije")
    private LocalDate datumRegistracije;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public LocalDate getDatumRegistracije() {
        return datumRegistracije;
    }

    public void setDatumRegistracije(LocalDate datumRegistracije) {
        this.datumRegistracije = datumRegistracije;
    }


}
