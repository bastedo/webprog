package rest.resources;


import core.entites.Account;
import core.enumeration.Uloga;
import org.springframework.hateoas.ResourceSupport;


import java.time.LocalDate;

public class AccountResource extends ResourceSupport {


    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private Uloga uloga;
    private LocalDate datumRegistracije;


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
    public Account toAccount() {
        Account account = new Account();
        account.setIme(ime);
        account.setKorisnickoIme(korisnickoIme);
        account.setDatumRegistracije(datumRegistracije);
        account.setLozinka(lozinka);
        account.setPrezime(prezime);
        account.setUloga(uloga);
        return account;
    }

    @Override
    public String toString() {
        return "AccountResource{" +
                "korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", uloga=" + uloga +
                ", datumRegistracije=" + datumRegistracije +
                '}';
    }
}
