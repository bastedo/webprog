package core.services.util;

import core.entites.Podforum;

import java.util.ArrayList;
import java.util.List;

public class PodforumList {
    private List<Podforum> podforums = new ArrayList<Podforum>();

    public PodforumList(List<Podforum> podforums) {
        this.podforums = podforums;
    }

    public List<Podforum> getPodforums() {
        return podforums;
    }

    public void setPodforums(List<Podforum> podforums) {
        this.podforums = podforums;
    }
}
