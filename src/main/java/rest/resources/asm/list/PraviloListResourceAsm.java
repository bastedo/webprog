package rest.resources.asm.list;

import core.services.util.PraviloList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.PraviloController;
import rest.resources.PraviloResource;
import rest.resources.asm.PraviloResourceAsm;
import rest.resources.list.PraviloListResource;

import java.util.List;

public class PraviloListResourceAsm extends ResourceAssemblerSupport<PraviloList, PraviloListResource> {


    public PraviloListResourceAsm() {
        super(PraviloController.class, PraviloListResource.class);
    }

    @Override
    public PraviloListResource toResource(PraviloList praviloList) {
        List<PraviloResource> resList = new PraviloResourceAsm().toResources(praviloList.getPravilos());
        PraviloListResource finalRes = new PraviloListResource();
        finalRes.setPravilos(resList);
        return finalRes;
    }
}