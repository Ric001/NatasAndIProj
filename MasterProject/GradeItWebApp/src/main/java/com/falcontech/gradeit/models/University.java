package com.falcontech.gradeit.models;

import java.util.List;

public class University {
    private String name;
    private List<Career> careers;
    private String indexType;
    
    public University() {}

    public University(String name, List<Career> careers, String indexType) {
        setName(name);
        setCareers(careers);
        setIndexType(indexType);
    }
    public String getName() {
        return name;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    public List<Career> getCareers() {
        return careers;
    }

    public void setCareers(List<Career> careers) {
        this.careers = careers;
    }

    public void setName(String name) {
        this.name = name;
    }
}