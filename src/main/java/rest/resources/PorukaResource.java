package rest.resources;

import core.entites.Account;
import core.entites.Poruka;
import org.springframework.hateoas.ResourceSupport;

public class PorukaResource extends ResourceSupport {


    private String sadrzajPoruke;

    private Boolean komentarIzmenjen;

    private Account primalac;

    private Account posiljalac;

    public String getSadrzajPoruke() {
        return sadrzajPoruke;
    }

    public void setSadrzajPoruke(String sadrzajPoruke) {
        this.sadrzajPoruke = sadrzajPoruke;
    }

    public Boolean getKomentarIzmenjen() {
        return komentarIzmenjen;
    }

    public void setKomentarIzmenjen(Boolean komentarIzmenjen) {
        this.komentarIzmenjen = komentarIzmenjen;
    }

    public Account getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Account primalac) {
        this.primalac = primalac;
    }

    public Account getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(Account posiljalac) {
        this.posiljalac = posiljalac;
    }

    public Poruka toPoruka () {
        Poruka poruka = new Poruka() ;
        poruka.setKomentarIzmenjen(komentarIzmenjen);
        poruka.setSadrzajPoruke(sadrzajPoruke);
        poruka.setPrimalac(primalac);
        poruka.setPosiljalac(posiljalac);

        return poruka ;
    }

}
