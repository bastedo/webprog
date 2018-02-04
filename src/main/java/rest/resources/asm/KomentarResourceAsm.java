package rest.resources.asm;

import core.entites.Komentar;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.KomentarController;
import rest.resources.KomentarResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class KomentarResourceAsm extends ResourceAssemblerSupport<Komentar, KomentarResource> {

    public KomentarResourceAsm() {
        super(Komentar.class, KomentarResource.class);
    }

    @Override
    public KomentarResource toResource(Komentar komentar) {
        KomentarResource res = new KomentarResource();
        
        Link link = linkTo(methodOn(KomentarController.class).getKomentar(komentar.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
