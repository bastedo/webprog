package rest.resources;

import org.springframework.hateoas.ResourceSupport;

public class SearchKorisnikResource extends ResourceSupport {
    private String korisnickoIme ;

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String toString() {
        return "SearchKorisnikResource{" +
                "korisnickoIme='" + korisnickoIme + '\'' +
                '}';
    }
}
