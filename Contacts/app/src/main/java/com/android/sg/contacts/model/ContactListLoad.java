package com.android.sg.contacts.model;

import java.util.ArrayList;

public class ContactListLoad {
    private ArrayList <ModelContactListFull> contactListFull = new ArrayList<>();
    private ArrayList <ModelContactListShort> contactListShort = new ArrayList<>();

    public ContactListLoad() {
        contactListFull.add(new ModelContactListFull("Pasha","Deni","093-155-91-52", new String[] {"C#","MySQL","WEB"},""));
        contactListFull.add(new ModelContactListFull("Pasha2","Deni2","093-155-91-52", new String[] {"C#","WEB"},""));
        contactListFull.add(new ModelContactListFull("Pasha3","Deni3","093-155-91-52", new String[] {"MySQL","WEB"},""));
        contactListShort = createShortList();
    }

    private ArrayList <ModelContactListShort> createShortList(){
        if (contactListFull == null) return null;
        ArrayList <ModelContactListShort> contactListShorts = new ArrayList<ModelContactListShort>();
        for (ModelContactListFull contact: contactListFull) {
            contactListShorts.add(new ModelContactListShort(
                    contact.getName() + " " + contact.getSurName(), contact.skillsAsString()
            ));
        }
        return contactListShorts;
    }

    public ArrayList <ModelContactListShort> loadShortList(){
        return contactListShort;
    }

    public ArrayList<ModelContactListFull> loadFullList() {
        return contactListFull;
    }

    public ArrayList<ModelContactListFull> saveFullList() {
        return contactListFull;
    }
}
