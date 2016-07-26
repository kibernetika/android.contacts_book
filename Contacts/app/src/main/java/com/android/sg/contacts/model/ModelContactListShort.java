package com.android.sg.contacts.model;

public class ModelContactListShort {

    public ModelContactListShort() {}

    public ModelContactListShort(String name, String surName, String[] skills) {
        this.name = name;
        this.surName = surName;
        this.skills = skills;
    }

    private String name;
    private String surName;
    private String [] skills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}
