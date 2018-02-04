package rest.resources.asm;

import core.entites.Tema;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.TemaController;
import rest.resources.TemaResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class TemaResourceAsm  extends ResourceAssemblerSupport<Tema, TemaResource> {

    public TemaResourceAsm() {
        super(Tema.class, TemaResource.class);
    }

    @Override
    public TemaResource toResource(Tema tema) {
        TemaResource res = new TemaResource();
        res.setAutor(tema.getAutor());
        res.setBrojNegativnihGlasova(tema.getBrojNegativnihGlasova());
        res.setBrojPozitivnihGlasova(tema.getBrojPozitivnihGlasova());
        res.setDatumKreiranja(tema.getDatumKreiranja());
        res.setNaslov(tema.getNaslov());
        res.setOpis(tema.getOpis());
        res.setPripadaPodforumu(tema.getPripadaPodforumu());
        res.setSlika(tema.getSlika());
        res.setSlikaContentType(tema.getSlikaContentType());
        res.setTekstualniSadrzaj(tema.getTekstualniSadrzaj());
        res.setTip(tema.getTip());

        Link link = linkTo(methodOn(TemaController.class).getTema(tema.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
