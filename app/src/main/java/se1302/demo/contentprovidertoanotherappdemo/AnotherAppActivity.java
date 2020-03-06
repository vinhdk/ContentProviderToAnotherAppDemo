package se1302.demo.contentprovidertoanotherappdemo;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

import se1302.demo.contentprovidertoanotherappdemo.adapters.StudentAdapter;
import se1302.demo.contentprovidertoanotherappdemo.models.StudentModel;

public class AnotherAppActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_app);
        String STUDENT_PROVIDER_NAME = "se1302.demo.contentproviderdemo.providers.StudentProvider";
        Uri STUDENT_CONTENT_URI =Uri.parse("content://" + STUDENT_PROVIDER_NAME + "/students");
        Cursor cursor = getContentResolver().query(STUDENT_CONTENT_URI, null, null, null, null);
        ArrayList<StudentModel> students = new ArrayList<StudentModel>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                students.add(new StudentModel(
                        cursor.getString(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getInt(cursor.getColumnIndex("core")),
                        cursor.getInt(cursor.getColumnIndex("isGraduate"))
                ));
                while (cursor.moveToNext()) {
                    StudentModel student = new StudentModel(
                            cursor.getString(cursor.getColumnIndex("id")),
                            cursor.getString(cursor.getColumnIndex("name")),
                            cursor.getInt(cursor.getColumnIndex("core")),
                            cursor.getInt(cursor.getColumnIndex("isGraduate"))
                    );
                    students.add(student);
                }
            }
            cursor.close();
        }
        this.setListAdapter(new StudentAdapter(this, students));

    }
}
