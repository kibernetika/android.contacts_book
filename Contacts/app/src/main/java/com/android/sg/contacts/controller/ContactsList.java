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
import com.android.sg.contacts.model.ModelContactListFull;
import com.android.sg.contacts.model.ModelContactListShort;

import java.util.ArrayList;

public class ContactsList extends AppCompatActivity {

    private LinearLayout listContacts;
    public ArrayList<ModelContactListFull> contactListFull = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        listContacts = (LinearLayout) findViewById(R.id.contacts_list_view);
        listContactsLoad();
    }

    protected void listContactsLoad() {
        ContactListLoad contactListLoad = new ContactListLoad();
        contactListFull = contactListLoad.loadFullList();
        ArrayList<ModelContactListShort> contactListShorts = contactListLoad.loadShortList();
        for (int i = 0; i < contactListShorts.size(); i++) {
            containerContactCreate(contactListShorts.get(i).getName(), contactListShorts.get(i).getSkills(), i + 1);
        }
    }

    protected void containerContactCreate(String name, String contact, int id) {
        View view = getLayoutInflater().inflate(R.layout.contact_short, null);
        TextView text = (TextView) view.findViewById(R.id.label_contact_name);
        text.setText(name);
        TextView text2 = (TextView) view.findViewById(R.id.label_contact_skills);
        text2.setText(contact);
        view.setId(-1 * id);
        listContacts.addView(view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void onClickListItem(View view) {
        Intent intent = new Intent(this,ContactInfo.class);
        intent.putExtra("id_contact", view.getId());
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
