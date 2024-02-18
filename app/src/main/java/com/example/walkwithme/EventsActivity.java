package com.example.walkwithme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * An activity that does two main functions:
 * 1. shows a list of events available to user using recycler view
 * 2. add events data from the database to the local variable "list"
 */
public class EventsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<Event> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        recyclerView = findViewById(R.id.recyclerView);

        // set recycler view adapter
        MyAdapter myAdapter = new MyAdapter(this, buildListData());
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    // list of random data, input database data here when needed
    private ArrayList<Event> buildListData() {
        list.add(new Event(1, R.drawable.logo, "Groceries", "Groceries anyone Coles City", "29/10/2021 16:00", "29/10/2021 19:00", 5.23, 52.66, 0, 3,  true));
        list.add(new Event(2, R.drawable.logo, "Walk", "Walking Lake Griffin", "29/10/2021 16:00", "29/10/2021 19:00", 5.23, 52.66, 0, 3,  true));
        list.add(new Event(3, R.drawable.logo, "Study buddies", "Hankock library", "29/10/2021 16:00", "29/10/2021 19:00", 5.23, 52.66, 0, 3,  true));
        list.add(new Event(4, R.drawable.logo, "Movie", "Movie night out? DENDY CITY","29/10/2021 16:00", "29/10/2021 19:00", 5.23, 52.66, 0, 3,  true));
        list.add(new Event(5, R.drawable.logo, "INFS3059 go to class", "Lets attend sigi class", "29/10/2021 16:00", "29/10/2021 19:00", 5.23, 52.66, 0, 3,  true));
        list.add(new Event(6, R.drawable.logo, "Walk with my dog", "Walk with my dog", "29/10/2021 16:00", "29/10/2021 19:00", 5.23, 52.66, 0, 3,  true));
        list.add(new Event(7, R.drawable.logo, "Carpool Walk", "Walk from B&G to my car", "29/10/2021 16:00", "29/10/2021 19:00", 5.23, 52.66, 0, 3,  true));
        list.add(new Event(8, R.drawable.logo, "Walk me to work", "Walk me to work at civic", "29/10/2021 16:00", "29/10/2021 19:00", 5.23, 52.66, 0, 3,  true));


        return list;
    }



}