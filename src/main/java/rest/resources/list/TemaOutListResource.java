package rest.resources.list;

import org.springframework.hateoas.ResourceSupport;
import rest.resources.TemaResource;

import java.util.ArrayList;
import java.util.List;

public class TemaListResource extends ResourceSupport {
    private List<TemaResource> temas = new ArrayList<TemaResource>();

    public List<TemaResource> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaResource> temas) {
        this.temas = temas;
    }
}
