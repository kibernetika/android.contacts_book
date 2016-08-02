package com.android.sg.contacts.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.android.sg.contacts.R;
import com.android.sg.contacts.model.ContactListDAO;
import com.android.sg.contacts.model.ContactListShortAdapter;
import com.android.sg.contacts.model.ModelContactListFull;
import com.android.sg.contacts.model.ModelContactListShort;

import java.io.Serializable;
import java.util.ArrayList;

public class ContactsList extends AppCompatActivity {

    private ListView listContacts;
    public ArrayList<ModelContactListFull> contactListFull = new ArrayList<>();
    String fileNameContactsList = "db";
    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSettings = getSharedPreferences(fileNameContactsList, Context.MODE_PRIVATE);
        contactListFull = ContactListDAO.ContactsListLoadFromFile(mSettings, fileNameContactsList);
        ContactsListLoadToViewList();
    }

    public void onClickListItem(View view) {
        Intent intent = new Intent(this, ContactInfo.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        int id = (view.getId() * -1) - 1;
        Bundle bundle = new Bundle();
        bundle.putSerializable("id_contact", (Serializable) contactListFull.get(id));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void ContactsListLoadToViewList() {
        ArrayList<ModelContactListShort> contactListShorts = ContactListDAO.createShortList(contactListFull);
        setContentView(R.layout.activity_contacts_list);
        listContacts = (ListView) findViewById(R.id.contacts_list);
        listContacts.setAdapter(new ContactListShortAdapter(this, contactListShorts));
    }

    @Override
    protected void onPause() {
        SharedPreferences mSettings = getSharedPreferences(fileNameContactsList, Context.MODE_PRIVATE);
        ContactListDAO.ContactsListSaveToFile(mSettings, fileNameContactsList, contactListFull);
        super.onPause();
    }

    public void buttonAddClick(View view) {
        Intent intent = new Intent(this, ContactInfo.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra("Edit", false);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        if ((bundle != null) && (bundle.containsKey("contact"))) {
            ModelContactListFull contact = (ModelContactListFull) bundle.getSerializable("contact");
            contactListFull.add(contact);
            ContactsListLoadToViewList();
        }
    }

    public void buttonExitClick(View view) {
        finish();
    }
}
