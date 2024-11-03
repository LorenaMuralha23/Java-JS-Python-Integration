package com.mycompany.testing;

public class ReceivedJSON {
    private String name;
    private String profession;

    public ReceivedJSON(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public ReceivedJSON() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    
}
