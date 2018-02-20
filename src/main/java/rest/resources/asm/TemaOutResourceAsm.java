package rest.resources.asm;

import core.entites.Tema;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.TemaController;
import rest.resources.TemaOutResource;
import rest.resources.TemaResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class TemaOutResourceAsm extends ResourceAssemblerSupport<Tema, TemaOutResource> {

    public TemaOutResourceAsm() {
        super(Tema.class, TemaOutResource.class);
    }

    @Override
    public TemaOutResource toResource(Tema tema) {
        TemaOutResource res = new TemaOutResource();
        res.setTemaId(tema.getId());
        res.setAutor(tema.getAutor());
        res.setBrojNegativnihGlasova(tema.getBrojNegativnihGlasova());
        res.setBrojPozitivnihGlasova(tema.getBrojPozitivnihGlasova());
        res.setDatumKreiranja(tema.getDatumKreiranja());
        res.setNaslov(tema.getNaslov());
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
