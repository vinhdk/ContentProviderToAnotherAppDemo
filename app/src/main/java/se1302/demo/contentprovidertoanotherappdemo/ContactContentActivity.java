package se1302.demo.contentprovidertoanotherappdemo;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

import se1302.demo.contentprovidertoanotherappdemo.adapters.ContactAdapter;
import se1302.demo.contentprovidertoanotherappdemo.models.ContactModel;

public class ContactContentActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_content);
        Uri CONTACT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        try {
            Cursor cursor = getContentResolver().query(CONTACT_URI, new String[] {ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
            ArrayList<ContactModel> contacts = new ArrayList<ContactModel>();
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    contacts.add(new ContactModel(
                            cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID)),
                            cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                            cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    ));
                    while (cursor.moveToNext()) {
                        ContactModel contact = new ContactModel(
                                cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID)),
                                cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                                cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                        );
                        contacts.add(contact);
                    }
                }
                cursor.close();
            }
            this.setListAdapter(new ContactAdapter(this, contacts));
        } catch (Exception e) {
            Log.d("MainActivity", "Error at onCreate " + e.getMessage());
        }

    }
}
