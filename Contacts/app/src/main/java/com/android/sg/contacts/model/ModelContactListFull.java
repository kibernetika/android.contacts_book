package com.android.sg.contacts.model;

public class ModelContactListFull {
    public ModelContactListFull() {}

    public ModelContactListFull(String name, String surName, String phone, String[] skills, String imagePath) {
        this.name = name;
        this.surName = surName;
        this.phone = phone;
        this.skills = skills;
        this.imagePath = imagePath;
    }

    private String name;
    private String surName;
    private String phone;
    private String [] skills;
    private String imagePath;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
