package com.android.sg.contacts.model;

public class ModelContactListShort {

    public ModelContactListShort() {}

    public ModelContactListShort(String name, String skills) {
        this.name = name;
        this.skills = skills;
    }

    private String name;
    private String skills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
