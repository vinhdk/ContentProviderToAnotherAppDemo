package se1302.demo.contentprovidertoanotherappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToRenderContact(View view) {
        Intent intent = new Intent(this, ContactContentActivity.class);
        startActivity(intent);
    }

    public void clickToAnotherApp(View view) {
        Intent intent = new Intent(this, AnotherAppActivity.class);
        startActivity(intent);
    }
}
