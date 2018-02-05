package core.entites;
/**
 *
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import core.enumeration.Uloga;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "email", nullable = false)
    private String email ;


    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Podforum> spisakPracenihPodforuma = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Tema> spisakSnimljenihTema = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Komentar> spisakSnimljenihKomentara = new HashSet<>();


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Podforum> getSpisakPracenihPodforuma() {
        return spisakPracenihPodforuma;
    }

    public void setSpisakPracenihPodforuma(Set<Podforum> spisakPracenihPodforuma) {
        this.spisakPracenihPodforuma = spisakPracenihPodforuma;
    }

    public Set<Tema> getSpisakSnimljenihTema() {
        return spisakSnimljenihTema;
    }

    public void setSpisakSnimljenihTema(Set<Tema> spisakSnimljenihTema) {
        this.spisakSnimljenihTema = spisakSnimljenihTema;
    }

    public Set<Komentar> getSpisakSnimljenihKomentara() {
        return spisakSnimljenihKomentara;
    }

    public void setSpisakSnimljenihKomentara(Set<Komentar> spisakSnimljenihKomentara) {
        this.spisakSnimljenihKomentara = spisakSnimljenihKomentara;
    }
}
