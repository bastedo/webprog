package rest.resources.asm;

import core.entites.Poruka;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.PorukaController;
import rest.resources.PorukaResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PorukaResourceAsm extends ResourceAssemblerSupport<Poruka, PorukaResource> {

    public PorukaResourceAsm() {
        super(Poruka.class, PorukaResource.class);
    }

    @Override
    public PorukaResource toResource(Poruka poruka) {
        PorukaResource res = new PorukaResource();
        res.setKomentarIzmenjen(poruka.getKomentarIzmenjen());
        res.setSadrzajPoruke(poruka.getSadrzajPoruke());
        res.setPrimalac(poruka.getPrimalac());
        res.setPosiljalac(poruka.getPosiljalac());
        Link link = linkTo(methodOn(PorukaController.class).getPoruka(poruka.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
