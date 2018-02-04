package rest.resources.list;

import org.springframework.hateoas.ResourceSupport;
import rest.resources.KomentarResource;

import java.util.ArrayList;
import java.util.List;

public class KomentarListResource extends ResourceSupport {
    private List<KomentarResource> komentar = new ArrayList<KomentarResource>();

    public List<KomentarResource> getKomentar() {
        return komentar;
    }

    public void setKomentars(List<KomentarResource> komentar) {
        this.komentar = komentar;
    }
}