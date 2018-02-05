package rest.resources.asm.list;

import core.services.util.OcenaList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.OcenaController;
import rest.resources.OcenaResource;
import rest.resources.asm.OcenaResourceAsm;
import rest.resources.list.OcenaListResource;

import java.util.List;

public class OcenaListResourceAsm extends ResourceAssemblerSupport<OcenaList, OcenaListResource> {


    public OcenaListResourceAsm() {
        super(OcenaController.class, OcenaListResource.class);
    }

    @Override
    public OcenaListResource toResource(OcenaList ocenaList) {
        List<OcenaResource> resList = new OcenaResourceAsm().toResources(ocenaList.getOcenas());
        OcenaListResource finalRes = new OcenaListResource();
        finalRes.setOcenas(resList);
        return finalRes;
    }
}
