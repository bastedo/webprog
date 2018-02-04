package rest.resources.list;

import org.springframework.hateoas.ResourceSupport;
import rest.resources.TemaResource;

import java.util.ArrayList;
import java.util.List;

public class TemaListResource extends ResourceSupport {
    private List<TemaResource> tema = new ArrayList<TemaResource>();

    public List<TemaResource> getTema() {
        return tema;
    }

    public void setTemas(List<TemaResource> tema) {
        this.tema = tema;
    }
}
