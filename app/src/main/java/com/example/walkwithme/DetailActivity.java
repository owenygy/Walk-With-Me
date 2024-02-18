package com.example.walkwithme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * An activity that connect Events activity when the event is clicked
 */
public class DetailActivity extends AppCompatActivity {

    Button join;

    ImageView mainImageView;
    TextView title, description;
    TextView date, start, end, location;

    String data1, data2;
    String data3, data4, data5, data6;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        // extra details in detail activity
        //date = findViewById(R.id.date);
        start = findViewById(R.id.start_time);
        end = findViewById(R.id.end_time);
        //location = findViewById(R.id.location);

        getData();
        setData();

        // set events button
        join = findViewById(R.id.button_join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create toast to show the activity has been joined successfully
                Toast toast = Toast.makeText(getApplicationContext(), "Join Successfully", Toast.LENGTH_SHORT);
                toast.show();

                // jump to next activity
                Intent intent = new Intent(getApplicationContext(), JoinSuccessfullyActivity.class);

                // putting data to next activity
                intent.putExtra("title", data1);
                intent.putExtra("description", data2);
                intent.putExtra("start", data4);

                startActivity(intent);
                finish();
            }
        });
    }

    private void getData() {
        data1 = getIntent().getStringExtra("title");
        data2 = getIntent().getStringExtra("description");
        myImage = getIntent().getIntExtra("myImage", 1);

        //data3 = getIntent().getStringExtra("date");
        data4 = getIntent().getStringExtra("start");
        data5 = getIntent().getStringExtra("end");
        //data6 = getIntent().getStringExtra("location");
    }

    private void setData() {
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);

        //date.setText(data3);
        start.setText(data4);
        end.setText(data5);
        //location.setText(data6);
    }
}