package rest.resources;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Ocena;
import core.entites.Tema;
import core.enumeration.VrstaOcene;
import org.springframework.hateoas.ResourceSupport;

public class OcenaResource extends ResourceSupport {
    private Account account;

    private Komentar komentar ;

    private Tema tema ;

    private VrstaOcene vrstaOcene ;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Komentar getKomentar() {
        return komentar;
    }

    public void setKomentar(Komentar komentar) {
        this.komentar = komentar;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public VrstaOcene getVrstaOcene() {
        return vrstaOcene;
    }

    public void setVrstaOcene(VrstaOcene vrstaOcene) {
        this.vrstaOcene = vrstaOcene;
    }
    public Ocena toOcena () {
        Ocena ocena = new Ocena();
        ocena.setAccount(account);
        ocena.setKomentar(komentar);
        ocena.setTema(tema);
        ocena.setVrstaOcene(vrstaOcene);
        return ocena ;
    }

    @Override
    public String toString() {
        return "OcenaResource{" +
                "account=" + account +
                ", komentar=" + komentar +
                ", tema=" + tema +
                ", vrstaOcene=" + vrstaOcene +
                '}';
    }
}
