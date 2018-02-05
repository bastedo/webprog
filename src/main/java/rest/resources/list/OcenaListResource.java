package rest.resources.list;

import org.springframework.hateoas.ResourceSupport;
import rest.resources.OcenaResource;

import java.util.ArrayList;
import java.util.List;

public class OcenaListResource extends ResourceSupport {
    private List<OcenaResource> ocena = new ArrayList<OcenaResource>();

    public List<OcenaResource> getOcena() {
        return ocena;
    }

    public void setOcenas(List<OcenaResource> ocena) {
        this.ocena = ocena;
    }
}