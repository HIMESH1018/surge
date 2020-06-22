package com.example.surge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Notices extends AppCompatActivity {

    EditText editText2;
    Button login;
    DatabaseReference dbRef;
    Notice not1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notices);

        editText2 = findViewById(R.id.editText2);
        login = findViewById(R.id.login);

        not1 = new Notice();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Notice");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (TextUtils.isEmpty(editText2.getText().toString()))
                    Toast.makeText(getApplicationContext(), "please Enter", Toast.LENGTH_SHORT).show();


                 else {
                    not1.setName(editText2.getText().toString().trim());

                    dbRef.push().setValue(not1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(), "Data Added", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Failed to add data", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

    }


}
