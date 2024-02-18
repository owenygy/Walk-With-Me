package com.example.walkwithme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Login Page
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static ArrayList<User> users = new ArrayList<>();
    Button login;
    Button signup;
    public User loginUser;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // UI component
        // hide title bar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        // full screen mode
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // load file
        try {
            loadUser("Login.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // set login button
        login = findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                EditText inputUserEmail = findViewById(R.id.input_Email);
                EditText inputPassword = findViewById(R.id.input_password);

                String username = inputUserEmail.getText().toString();
                String password = inputPassword.getText().toString();


                 loginUser = findUser(username);

                if(loginUser != null) {
                    if(loginUser.password.equals(password)) {
                        try {
                            recordLoginUser(loginUser.id);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Please enter a correct username/password!",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please register your account first",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // set signup button
        signup = findViewById(R.id.button_Signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });


        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public void loadUser(String filePath) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open(filePath), StandardCharsets.UTF_8));
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                String[] tokens = line.split(",");
                User user = new User(1,tokens[0], tokens[1], new String(), new String(), new String(), 20,
                        new String(), 5, "");
                users.add(user);
            }
        }

        public User findUser(String inputUsername) {
            User out = null;
            for(User user : users) {
                if(user.userEmail.equals(inputUsername)) {
                    out = user;
                    break;
                }
            }
            return out;
        }

        public void recordLoginUser(int LoginUserID) throws IOException{
            FileWriter fw = new FileWriter("CurrentLogin.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write(LoginUserID);
            bufferedWriter.flush();
            bufferedWriter.close();
        }



}