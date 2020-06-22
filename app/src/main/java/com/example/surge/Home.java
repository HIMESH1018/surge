package com.example.surge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    ImageView imageView5,imageView2,imageView3,imageView12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageView5 = findViewById(R.id.imageView5);//Uploader
        imageView2 = findViewById(R.id.imageView2);//Safe_places
        imageView3 = findViewById(R.id.imageView3);//Donation
        imageView12 = findViewById(R.id.imageView12);//Water_Level


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Home.this,Notices.class);
                startActivity(intent);
            }
        });
    }
}
