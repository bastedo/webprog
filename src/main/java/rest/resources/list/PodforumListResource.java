package rest.resources.list;

import org.springframework.hateoas.ResourceSupport;
import rest.resources.PodforumResource;

import java.util.ArrayList;
import java.util.List;

public class PodforumListResource extends ResourceSupport {
    private List<PodforumResource> podforum = new ArrayList<PodforumResource>();

    public List<PodforumResource> getPodforum() {
        return podforum;
    }

    public void setPodforum(List<PodforumResource> podforum) {
        this.podforum = podforum;
    }
}
