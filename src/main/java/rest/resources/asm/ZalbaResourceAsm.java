package rest.resources.asm;

import core.entites.Zalba;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.ZalbaController;
import rest.resources.ZalbaResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ZalbaResourceAsm extends ResourceAssemblerSupport<Zalba, ZalbaResource> {

    public ZalbaResourceAsm() {
        super(Zalba.class, ZalbaResource.class);
    }

    @Override
    public ZalbaResource toResource(Zalba zalba) {
        ZalbaResource res = new ZalbaResource();
        res.setAutor(zalba.getAutor());
        res.setTekstZalbe(zalba.getTekstZalbe());
        res.setDatumZalbe(zalba.getDatumZalbe());
        res.setOdgovorniModerator(zalba.getOdgovorniModerator());
        res.setRegulisana(zalba.getRegulisana());

        Link link = linkTo(methodOn(ZalbaController.class).getZalba(zalba.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}