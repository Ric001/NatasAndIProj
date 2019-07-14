package com.falcontech.gradeit.models;

import java.util.List;
import java.util.Objects;

public class Pensum {
    private int totalCredits;
    private List<Subject> subjects;
    
    public Pensum(List<Subject> subjects) {
        setSubjects(subjects);
    }
    public void totalCredits() {
        if (Objects.nonNull(subjects))
            subjects.stream().forEach((Subject s) -> {
               totalCredits += s.getCredits(); 
            });
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}