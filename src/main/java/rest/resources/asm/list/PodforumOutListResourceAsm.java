package rest.resources.asm.list;

import core.services.util.PodforumList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.PodforumController;
import rest.resources.PodforumResource;
import rest.resources.asm.PodforumResourceAsm;
import rest.resources.list.PodforumListResource;

import java.util.List;

public class PodforumListResourceAsm extends ResourceAssemblerSupport<PodforumList, PodforumListResource> {
    public PodforumListResourceAsm() {
        super(PodforumController.class, PodforumListResource.class);
    }

    @Override
    public PodforumListResource toResource(PodforumList podforumList) {
        List<PodforumResource> resList = new PodforumResourceAsm().toResources(podforumList.getPodforums());
        PodforumListResource finalRes = new PodforumListResource();
        finalRes.setPodforum(resList);
        return finalRes;
    }
}
