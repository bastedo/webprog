package rest.resources.list;

import org.springframework.hateoas.ResourceSupport;
import rest.resources.PorukaResource;

import java.util.ArrayList;
import java.util.List;

public class PorukaListResource extends ResourceSupport {
    private List<PorukaResource> poruka = new ArrayList<PorukaResource>();

    public List<PorukaResource> getPoruka() {
        return poruka;
    }

    public void setPorukas(List<PorukaResource> poruka) {
        this.poruka = poruka;
    }
}
