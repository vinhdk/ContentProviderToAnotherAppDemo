package se1302.demo.contentprovidertoanotherappdemo.adapters;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import se1302.demo.contentprovidertoanotherappdemo.models.ContactModel;

public class ContactAdapter extends BaseAdapter<ContactModel> {
    public ContactAdapter(Context context, ArrayList<ContactModel> list) {
        super(context, list);
    }
    @Override
    public void drawText(TextView textView, ContactModel model) {
        textView.setText("Name: " + model.getName() + " Phone:" + model.getPhone());
    }

}