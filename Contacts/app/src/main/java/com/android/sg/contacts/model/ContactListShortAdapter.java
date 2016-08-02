package com.android.sg.contacts.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.sg.contacts.R;

import java.util.ArrayList;

public class ContactListShortAdapter extends BaseAdapter {

    ArrayList<ModelContactListShort> contactsArray;
    Context context;
    int count = 0;
    private static LayoutInflater inflater = null;

    public ContactListShortAdapter(Activity context, ArrayList<ModelContactListShort> contactListShorts) {
        contactsArray = contactListShorts;
        count = contactListShorts.size();
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder {
        ImageView photo;
        TextView nameFull;
        TextView skills;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        View contact;
        contact = inflater.inflate(R.layout.contact_short, null);
        holder.photo = (ImageView) contact.findViewById(R.id.contact_photo);
        holder.nameFull = (TextView) contact.findViewById(R.id.label_contact_name);
        holder.skills = (TextView) contact.findViewById(R.id.label_contact_skills);

        holder.photo.setImageResource(R.mipmap.contact_photo);
        holder.nameFull.setText(contactsArray.get(i).getName());
        holder.skills.setText(contactsArray.get(i).getSkills());
        contact.setId((i + 1) * -1);

        return contact;
    }
}
