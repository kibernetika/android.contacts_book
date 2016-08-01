package com.android.sg.contacts.model;

public class ModelContactListShort {

    public ModelContactListShort() {}

    public ModelContactListShort(String name, String skills, String photo) {
        this.name = name;
        this.skills = skills;
        this.photo = photo;
    }

    private String name;
    private String skills;
    private String photo;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
