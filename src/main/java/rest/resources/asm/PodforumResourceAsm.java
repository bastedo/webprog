package rest.resources.asm;

import core.entites.Podforum;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.AccountController;
import rest.mvc.PodforumController;
import rest.resources.PodforumResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PodforumResourceAsm extends ResourceAssemblerSupport<Podforum, PodforumResource> {
    public PodforumResourceAsm() {
        super(Podforum.class, PodforumResource.class);
    }

    @Override
    public PodforumResource toResource(Podforum podforum) {
        PodforumResource res = new PodforumResource();
        res.setNaziv(podforum.getNaziv());
        res.setOpis(podforum.getOpis());
        res.setOdgovorniModerator(podforum.getOdgovorniModerator());
        res.setIkonicaContentType(podforum.getIkonicaContentType());
        res.setAutor(podforum.getAutor());
        Link link = linkTo(methodOn(PodforumController.class).getPodforum(podforum.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
