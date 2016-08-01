package com.android.sg.contacts.model;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ContactListDAO {

    public static ArrayList<ModelContactListShort> createShortList(ArrayList<ModelContactListFull> contactsList) {
        if (contactsList == null) return null;
        ArrayList<ModelContactListShort> contactListShorts = new ArrayList<ModelContactListShort>();
        for (ModelContactListFull contact : contactsList) {
            contactListShorts.add(new ModelContactListShort(
                    contact.getName() + " " + contact.getSurName(), contact.skillsAsString(), contact.getImagePath()));
        }
        return contactListShorts;
    }

    public static Set<String> contactsToJSON(ArrayList<ModelContactListFull> contactsList) {
        Set<String> setContactJSON = new HashSet<>();
        Gson gson = new Gson();
        for (ModelContactListFull contact : contactsList) {
            String contactInJSON = gson.toJson(contact);
            setContactJSON.add(contactInJSON);
        }
        return setContactJSON;
    }

    public static ArrayList<ModelContactListFull> JSONtoContacts(Set<String> setContactJSON) {
        ArrayList<ModelContactListFull> contactsList = new ArrayList<>();
        Gson gson = new Gson();
        for (String contact : setContactJSON) {
            ModelContactListFull contactInJSON = gson.fromJson(contact, ModelContactListFull.class);
            contactsList.add(contactInJSON);
        }
        return contactsList;
    }

    public static void ContactsListSaveToFile(SharedPreferences mSettings, String FileName, ArrayList<ModelContactListFull> contactsList) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putStringSet(FileName, contactsToJSON(contactsList));
        editor.apply();
    }

    public static ArrayList<ModelContactListFull> ContactsListLoadFromFile(SharedPreferences mSettings, String FileName) {
        if (mSettings.contains(FileName)) {
            Set<String> contactsJSON = mSettings.getStringSet(FileName, null);
            return JSONtoContacts(contactsJSON);
        } else {
            ArrayList<ModelContactListFull> contactsList = new ArrayList<>();
            contactsList.add(new ModelContactListFull("TestName", "TestSurName", "012-345-67-89", new String[]{"C#", "MySQL", "WEB"}, "@mipmap/contact_photo"));
            return contactsList;
        }
    }
}