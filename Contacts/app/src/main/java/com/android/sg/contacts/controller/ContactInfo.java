package com.android.sg.contacts.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.sg.contacts.R;
import com.android.sg.contacts.model.ModelContactListFull;

import java.io.Serializable;

public class ContactInfo extends AppCompatActivity {

    public TextView name;
    public TextView surName;
    public TextView phone;
    public TextView skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        name = (TextView) findViewById(R.id.et_contact_name);
        surName = (TextView) findViewById(R.id.et_contact_surname);
        phone = (TextView) findViewById(R.id.et_contact_phone);
        skills = (TextView) findViewById(R.id.et_contact_skills);
        Bundle bundle = getIntent().getExtras();
        if ((bundle != null) && (bundle.containsKey("id_contact"))) {
            editTextLoadData(bundle);
            editTextReadOnly(true);
        } else {
            editTextClearData();
            editTextReadOnly(false);
            editButtonCreate(this.getIntent().getBooleanExtra("edit", false));
        }
    }

    public void buttonBackClick(View view) {
        Intent intent = new Intent(this, ContactsList.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void buttonSaveClickAdd(View view) {
        ModelContactListFull contact = new ModelContactListFull();
        contact.setName(name.getText().toString());
        contact.setSurName(surName.getText().toString());
        contact.setPhone(phone.getText().toString());
        String skills = this.skills.getText().toString();
        contact.setSkills(skills.split(","));
        Intent intent = new Intent(this, ContactsList.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("contact", (Serializable) contact);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void buttonSaveClickEdit(View view) {

    }

    public void buttonCancelClick(View view) {
        buttonBackClick(view);
    }

    protected void editButtonCreate(boolean edit) {
        ImageButton buttonCancel = (ImageButton) findViewById(R.id.button_cancel);
        buttonCancel.setVisibility(View.VISIBLE);
        ImageButton buttonSave = (ImageButton) findViewById(R.id.button_save);
        buttonSave.setVisibility(View.VISIBLE);
        if (edit) {
            buttonSave.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    buttonSaveClickEdit(view);
                }
            });
        } else {
            buttonSave.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    buttonSaveClickAdd(view);
                }
            });
        }
    }

    protected void editTextReadOnly(boolean readOff) {
        int type = -1;
        if (readOff) {
            type = View.LAYER_TYPE_NONE;
        } else {
            type = View.LAYER_TYPE_SOFTWARE;
        }
        name.setInputType(type);
        surName.setInputType(type);
        phone.setInputType(type);
        skills.setInputType(type);
    }

    private void editTextLoadData(Bundle bundle) {
        ModelContactListFull contact = (ModelContactListFull) bundle.getSerializable("id_contact");
        name.setText(contact.getName());
        surName.setText(contact.getSurName());
        phone.setText(contact.getPhone());
        skills.setText(contact.skillsAsString());
    }

    private void editTextClearData() {
        name.setText("");
        surName.setText("");
        phone.setText("");
        skills.setText("");
    }

}
