package com.example.walkwithme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public class ProfileActivity extends AppCompatActivity {

    String ProfileName;
    String Major;
    String Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        // TODO retrieving date from database to the user interface



        if (getIntent().getStringExtra("passName")==null){
            // retrieve data from database
            ProfileName = "Sigi";
        }
        else{
            ProfileName= getIntent().getStringExtra("passName");
        }
        TextView showName = (TextView) findViewById(R.id.profile_Name_textView);
        showName.setText(ProfileName);

        //  retrieve data from database
        String Email = "u12345678@anu.edu.au";
        TextView showEmail = (TextView) findViewById(R.id.profile_Email_TextView);
        showEmail.setText(Email);

        //  retrieve data from database
        String Gender = "Male";
        TextView showGender = (TextView) findViewById(R.id.profile_GenderTextView);
        showGender.setText(Gender);

        //  retrieve data from database
        String Age = "23";
        TextView showAge = (TextView) findViewById(R.id.profile_profile_AgeTextView);
        showAge.setText(Age);

        //  retrieve data from database
        String College = "CSIT";
        TextView showCollege = (TextView) findViewById(R.id.profile_CollegeTextView);
        showCollege.setText(College);


        if (getIntent().getStringExtra("passMajor")==null){
            // retrieve data from database
            Major = "Information system";
        }
        else{
            Major= getIntent().getStringExtra("passMajor");
        }
        TextView showMajor = (TextView) findViewById(R.id.profile_Major_TextView);
        showMajor.setText(Major);



        if (getIntent().getStringExtra("passDescription")==null){
            //  retrieve data from database
            Description = "  Nice to meet you all, enjoy doing the group project";
        }
        else{
            Description = "  " + getIntent().getStringExtra("passDescription");
        }
        TextView showDescription = (TextView) findViewById(R.id.profile_DescriptionTextView);
        showDescription.setText(Description);


        //When press on Sign out button
        Button SignOut = findViewById(R.id.sign_out_button);
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    logoutRecord();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Button homePage = findViewById(R.id.buttonhomePage);
        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(intent);
            }
        });

        //When press on edit button
        Button Edit = findViewById(R.id.editProfile_button);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }


    public void logoutRecord() throws IOException {
        File fw = new File("CurrentLogin.csv");
        if (fw.exists() && fw.isFile())
        {
            fw.delete();
        }
        fw.createNewFile();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

}
