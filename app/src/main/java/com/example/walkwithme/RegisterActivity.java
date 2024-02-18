package com.example.walkwithme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private EditText email;
    private EditText age;
    private Spinner GenderSpinner;
    private Spinner CollegeSpinner;
    private EditText major;
    private EditText selfDescription;

    // pattern is for password matching, which include the condition to ensure it is a strong password
    private static final Pattern password_pattern =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +         // at least 1 special character
                    "(?=.*[0-9])" +              // with number
                    "(?=.*[a-z])(?=.*[A-Z])"+    // with either upper or lower case
                    "(?=\\S+$).{8,20}$");        // no white spaces and at least 8 characters long

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.Register_input_UserName);
        email = findViewById(R.id.Register_input_Email);
        password =findViewById(R.id.Register_input_password);
        age = findViewById(R.id.Register_input_age);
        major = findViewById(R.id.Register_input_major);
        selfDescription = findViewById(R.id.Register_input_description);

        //For the Gender Spinner
        GenderSpinner = (Spinner) findViewById(R.id.Register_spinner_Gender);
        ArrayAdapter<String> GenderAdpter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Register_Gender));
        GenderAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GenderSpinner.setAdapter(GenderAdpter);

        //for College spinner
        CollegeSpinner = (Spinner) findViewById(R.id.register_spinner_College);
        ArrayAdapter<String> CollegeAdpter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Register_College));
        CollegeAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CollegeSpinner.setAdapter(CollegeAdpter);

        //When press on Register button
        Button Register = findViewById(R.id.button_register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( validateName() && validateANUEmailAddress() && validatePassword() && validateAge() && validateCollege()){
                    // TODO insert data into database

                    Toast.makeText(RegisterActivity.this, "Register Success!!!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(RegisterActivity.this, "Sorry,Register Fail...", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validateName() {
        String nameInput = name.getText().toString();
        // check if User name field is empty
        if(nameInput.isEmpty()){
            name.setError("User Name cannot be empty");
            return false;
        } else{
            name.setError(null);
            return true;
        }
    }

    // check is it a validate ANU student Email
    private boolean validateANUEmailAddress(){
        String emailInput = email.getText().toString();
        // check if email field is empty
        if (emailInput.isEmpty()){
            email.setError("Email cannot be empty");
            return false;}
        // check if it is an ANU email address
        else if(!emailInput.contains("@anu.edu.au")){
            email.setError("Please enter ANU student email");
            return false;}
        else{
            email.setError(null);
            return true;
        }
    }


    // check the password is strong enough
    private boolean validatePassword() {
        String passwordInput = password.getText().toString().trim();
        // check if password field is empty
        if (passwordInput.isEmpty()) {
            password.setError("Password cannot be empty");
            return false;
        }
        // check if password does not matches to the pattern
        else if (!password_pattern.matcher(passwordInput).matches()) {
            password.setError("It should contain:~ -at least 1 special character(@#$%^&+=)~ -with number(0-9)~ -with either upper or lower case character~ -at least 8 characters long"
                    .replaceAll("~+","\n"));
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }

    private boolean validateAge() {
        String nameInput = age.getText().toString();
        // check if age field is empty
        if(nameInput.isEmpty()){
            age.setError("age cannot be empty");
            return false;
        } else{
            age.setError(null);
            return true;
        }
    }

    private boolean validateCollege() {
        String collegeInput = CollegeSpinner.getSelectedItem().toString();
        // check if college field is empty
        if( collegeInput.isEmpty()){
            ((TextView)CollegeSpinner.getSelectedView()).setError("College cannot be empty");
            return false;
        } else{
            ((TextView)CollegeSpinner.getSelectedView()).setError(null);
            return true;
        }
    }



}

