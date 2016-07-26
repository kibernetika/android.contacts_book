package com.android.sg.contacts.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.sg.contacts.R;
import com.android.sg.contacts.model.ContactListLoad;
import com.android.sg.contacts.model.ModelContactListShort;

import java.util.ArrayList;
import java.util.Arrays;

public class ContactsList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        listView = (ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        listLoad(listView);
    }

    protected void listLoad(ListView listView){
        ArrayList<ModelContactListShort> contactListShorts = new ContactListLoad().loadShortList();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> skills = new ArrayList<>();
        for (ModelContactListShort contact: contactListShorts){
            names.add(contact.getName()+" "+contact.getSurName());
            skills.add(Arrays.toString(contact.getSkills()));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this,ContactInfo.class);
        intent.putExtra("id_contact", listView.getSelectedItemId());
        startActivity(intent);
    }

}
