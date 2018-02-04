package rest.resources.asm.list;

import core.services.util.KomentarList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.KomentarController;
import rest.resources.KomentarResource;
import rest.resources.asm.KomentarResourceAsm;
import rest.resources.list.KomentarListResource;

import java.util.List;

public class KomentarListResourceAsm extends ResourceAssemblerSupport<KomentarList, KomentarListResource> {


    public KomentarListResourceAsm() {
        super(KomentarController.class, KomentarListResource.class);
    }

    @Override
    public KomentarListResource toResource(KomentarList komentarList) {
        List<KomentarResource> resList = new KomentarResourceAsm().toResources(komentarList.getKomentars());
        KomentarListResource finalRes = new KomentarListResource();
        finalRes.setKomentars(resList);
        return finalRes;
    }
}
