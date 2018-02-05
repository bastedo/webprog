package rest.resources.asm;

import core.entites.Ocena;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.OcenaController;
import rest.resources.OcenaResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class OcenaResourceAsm extends ResourceAssemblerSupport<Ocena, OcenaResource> {
    public OcenaResourceAsm() {
        super(Ocena.class, OcenaResource.class);
    }

    @Override
    public OcenaResource toResource(Ocena ocena) {
        OcenaResource res = new OcenaResource();
        res.setAccount(ocena.getAccount());
        res.setKomentar(ocena.getKomentar());
        res.setTema(ocena.getTema());
        res.setVrstaOcene(ocena.getVrstaOcene());
        Link link = linkTo(methodOn(OcenaController.class).getOcena(ocena.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}