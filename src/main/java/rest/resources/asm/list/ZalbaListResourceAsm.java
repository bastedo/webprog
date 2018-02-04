package rest.resources.asm.list;

import core.services.util.ZalbaList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.ZalbaController;
import rest.resources.ZalbaResource;
import rest.resources.asm.ZalbaResourceAsm;
import rest.resources.list.ZalbaListResource;

import java.util.List;

public class ZalbaListResourceAsm extends ResourceAssemblerSupport<ZalbaList, ZalbaListResource> {


    public ZalbaListResourceAsm() {
        super(ZalbaController.class, ZalbaListResource.class);
    }

    @Override
    public ZalbaListResource toResource(ZalbaList zalbaList) {
        List<ZalbaResource> resList = new ZalbaResourceAsm().toResources(zalbaList.getZalbas());
        ZalbaListResource finalRes = new ZalbaListResource();
        finalRes.setZalbas(resList);
        return finalRes;
    }
}