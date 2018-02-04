package rest.resources.asm;

import core.entites.Pravilo;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.PraviloController;
import rest.resources.PraviloResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PraviloResourceAsm extends ResourceAssemblerSupport<Pravilo, PraviloResource> {
    public PraviloResourceAsm() {
        super(Pravilo.class, PraviloResource.class);
    }

    @Override
    public PraviloResource toResource(Pravilo pravilo) {
        PraviloResource res = new PraviloResource();
        res.setNazivPravila(pravilo.getNazivPravila());
        res.setSadrzajPravila(pravilo.getSadrzajPravila());
        Link link = linkTo(methodOn(PraviloController.class).getPravilo(pravilo.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}