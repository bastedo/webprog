package rest.resources.list;

import org.springframework.hateoas.ResourceSupport;
import rest.resources.ZalbaResource;

import java.util.ArrayList;
import java.util.List;

public class ZalbaListResource extends ResourceSupport {
    private List<ZalbaResource> zalba = new ArrayList<ZalbaResource>();

    public List<ZalbaResource> getZalba() {
        return zalba;
    }

    public void setZalbas(List<ZalbaResource> zalba) {
        this.zalba = zalba;
    }
}
