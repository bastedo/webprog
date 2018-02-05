package rest.resources;

import core.entites.Account;
import core.entites.Podforum;
import org.springframework.hateoas.ResourceSupport;

public class SearchTemaResource extends ResourceSupport {

    private String naslov;
    private String sadrzaj;
    private String autor;
    private String podforum;

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPodforum() {
        return podforum;
    }

    public void setPodforum(String podforum) {
        this.podforum = podforum;
    }

    @Override
    public String toString() {
        return "SearchTemaResource{" +
                "naslov='" + naslov + '\'' +
                ", sadrzaj='" + sadrzaj + '\'' +
                ", autor=" + autor +
                ", podforum=" + podforum +
                '}';
    }
}
