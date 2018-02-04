package rest.resources.list;

import org.springframework.hateoas.ResourceSupport;
import rest.resources.PraviloResource;

import java.util.ArrayList;
import java.util.List;

public class PraviloListResource extends ResourceSupport {
    private List<PraviloResource> pravilo = new ArrayList<PraviloResource>();

    public List<PraviloResource> getPravilo() {
        return pravilo;
    }

    public void setPravilos(List<PraviloResource> pravilo) {
        this.pravilo = pravilo;
    }
}
