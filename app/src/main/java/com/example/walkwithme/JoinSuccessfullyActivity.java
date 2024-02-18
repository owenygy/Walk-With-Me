package com.example.walkwithme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JoinSuccessfullyActivity extends AppCompatActivity {

    Button leaveWalk;

    TextView title, description, startTime;
    String data1, data2, data3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_successfully);

        title = findViewById(R.id.join_title);
        description = findViewById(R.id.join_description);
        startTime = findViewById(R.id.join_time);

        getData();
        setData();

        // set events button
        leaveWalk = findViewById(R.id.button_leave);
        leaveWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create toast to show the activity has been joined successfully
                Toast toast = Toast.makeText(getApplicationContext(), "Leave Successfully", Toast.LENGTH_SHORT);
                toast.show();

                // jump to next activity
                Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getData() {
        data1 = getIntent().getStringExtra("title");
        data2 = getIntent().getStringExtra("description");
        data3 = getIntent().getStringExtra("start");
    }

    private void setData() {
        title.setText(data1);
        description.setText(data2);
        startTime.setText(data3);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}