package com.android.sg.contacts.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sg.contacts.R;
import com.android.sg.contacts.model.ContactListLoad;
import com.android.sg.contacts.model.ModelContactListShort;

import java.util.ArrayList;

public class ContactsList extends AppCompatActivity {

    private LinearLayout listContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        listContacts = (LinearLayout) findViewById(R.id.contacts_list_view);
        listContactsLoad();
    }

    protected void listContactsLoad() {
        ArrayList<ModelContactListShort> contactListShorts = new ContactListLoad().loadShortList();
        for (ModelContactListShort contact: contactListShorts){
            containerContactCreate(contact.getName(), contact.getSkills());
        }
    }

    protected void containerContactCreate(String name, String contact) {
        LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = getLayoutInflater().inflate(R.layout.contact_short, null);
        TextView text = (TextView) view.findViewById(R.id.label_contact_name);
        text.setText(name);
        TextView text2 = (TextView) view.findViewById(R.id.label_contact_skills);
        text2.setText(contact);
        listContacts.addView(view, containerParams);
//        LinearLayout containerContact = new LinearLayout(this);
//        containerContact.setOrientation(LinearLayout.VERTICAL);
//        containerContact.setPadding(5,5,5,5);
//        containerContact.setBackgroundResource(R.color.colorBacgroundContact);
//        containerContact.layout(3,3,3,3);
//        listContacts.addView(containerContact, containerParams);
//        Button btnNew = new Button(this);
//        btnNew.setText("test button");
//        listContacts.addView(btnNew);
    }

    public void onClickListItem(View view) {
        Intent intent = new Intent(this,ContactInfo.class);
        intent.putExtra("id_contact", 100500);
        startActivity(intent);
    }
}
