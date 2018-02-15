package rest.resources.list;

import org.springframework.hateoas.ResourceSupport;
import rest.resources.PodforumResource;

import java.util.ArrayList;
import java.util.List;

public class PodforumListResource extends ResourceSupport {
    private List<PodforumResource> podforums = new ArrayList<PodforumResource>();

    public List<PodforumResource> getPodforums() {
        return podforums;
    }

    public void setPodforum(List<PodforumResource> podforums) {
        this.podforums = podforums;
    }
}
