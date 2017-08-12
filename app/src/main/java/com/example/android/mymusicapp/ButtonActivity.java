package com.example.android.mymusicapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    private Button b7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create a new intent for opening order via email
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.paypal.com"));
                startActivity(intent);
                //creating sending message toast
                Toast.makeText(getApplicationContext(),
                        "redirecting to paypal", Toast.LENGTH_SHORT).show();
            }

        });
    }

}