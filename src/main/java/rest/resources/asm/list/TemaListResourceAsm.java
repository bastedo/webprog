package rest.resources.asm.list;

import core.services.util.TemaList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.TemaController;
import rest.resources.TemaResource;
import rest.resources.asm.TemaResourceAsm;
import rest.resources.list.TemaListResource;

import java.util.List;

public class TemaListResourceAsm extends ResourceAssemblerSupport<TemaList, TemaListResource> {


    public TemaListResourceAsm() {
        super(TemaController.class, TemaListResource.class);
    }

    @Override
    public TemaListResource toResource(TemaList temaList) {
        List<TemaResource> resList = new TemaResourceAsm().toResources(temaList.getTemas());
        TemaListResource finalRes = new TemaListResource();
        finalRes.setTemas(resList);
        return finalRes;
    }
}
