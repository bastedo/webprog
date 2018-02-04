package rest.resources.asm.list;

import core.services.util.PorukaList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.PorukaController;
import rest.resources.PorukaResource;
import rest.resources.asm.PorukaResourceAsm;
import rest.resources.list.PorukaListResource;

import java.util.List;

public class PorukaListResourceAsm extends ResourceAssemblerSupport<PorukaList, PorukaListResource> {


    public PorukaListResourceAsm() {
        super(PorukaController.class, PorukaListResource.class);
    }

    @Override
    public PorukaListResource toResource(PorukaList porukaList) {
        List<PorukaResource> resList = new PorukaResourceAsm().toResources(porukaList.getPorukas());
        PorukaListResource finalRes = new PorukaListResource();
        finalRes.setPorukas(resList);
        return finalRes;
    }
}