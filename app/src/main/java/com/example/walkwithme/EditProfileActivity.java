package com.example.walkwithme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;
import java.util.regex.Pattern;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {

    private EditText password;
    private EditText name;
    private EditText major;
    private Button FinishUpdate;
    private EditText selfDescription;

    private static final Pattern password_pattern =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +         // at least 1 special character
                    "(?=.*[0-9])" +              // with number
                    "(?=.*[a-z])(?=.*[A-Z])"+    // with either upper or lower case
                    "(?=\\S+$).{8,20}$");        // no white spaces and at least 8 characters long

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name = findViewById(R.id.Update_input_UserName);
        major = findViewById(R.id.Update_input_major);
        password = findViewById(R.id.Update_input_password1);
        selfDescription = findViewById(R.id.Update_input_description);



        FinishUpdate = findViewById(R.id.button_edit_update);
        FinishUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameInput = name.getText().toString();
                String majorInput = major.getText().toString();
                String selfDescriptionInput = selfDescription.getText().toString();
                String passwordInput = password.getText().toString().trim();

                if (nameInput.isEmpty()&&majorInput.isEmpty()&&selfDescriptionInput.isEmpty()&&passwordInput.isEmpty()){
                Toast.makeText(EditProfileActivity.this, "There is nothing updated!!!",
                        Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);


                if (!nameInput.isEmpty()){
                    //TODO: there is update with name to database

                    i.putExtra("passName", nameInput);
                    startActivity(i);




                }

                if(!majorInput.isEmpty()){
                    //TODO: there is update with major to database

                    i.putExtra("passMajor", majorInput);
                    startActivity(i);



                }

                if (!selfDescriptionInput.isEmpty()){
                    //TODO: there is update with self Description to database

                    i.putExtra("passDescription", selfDescriptionInput);
                    startActivity(i);



                }


                if (passwordInput.isEmpty()){
                    startActivity(i);

                } else {
                    if (validatePassword()){
                        // TODO: there is update of password to database
                        startActivity(i);

                    }
                }


                finish();
            }
        });

    }


    private boolean validatePassword( ) {
        String passwordInput = password.getText().toString().trim();

        // if password does not matches to the pattern
        // it will display an error message "Password is too weak"
        if (!password_pattern.matcher(passwordInput).matches()) {
            password.setError("It should contain:~ -at least 1 special character(@#$%^&+=)~ -with number(0-9)~ -with Upper and Lower case character~ -at least 8 characters long"
                    .replaceAll("~+","\n"));
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }



}