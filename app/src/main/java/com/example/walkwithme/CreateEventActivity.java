package com.example.walkwithme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CreateEventActivity extends AppCompatActivity {

    private TextView startDateTextView;
    private TextView startTimeTextView;
    private TextView endTimeTextView;
    private TextView endDateTextView;
    DatePickerDialog.OnDateSetListener setListenerStartDate;
    TimePickerDialog.OnTimeSetListener setListenerStartTime;
    DatePickerDialog.OnDateSetListener setListenerEndDate;
    TimePickerDialog.OnTimeSetListener setListenerEndTime;
    String sDate = null;
    String eDate = null;
    String sTime = null;
    String eTime = null;
    String strTemp = new String();
    Button CreateEvent;
    Button addLocation;
    private EditText eventName;
    String eventNameInput;
    int maxParticipantInput;
    private EditText MaxParticpant;
    public double longitude = 0;
    public double latitude = 0;
    public Date startDateTime;
    public Date endDateTime;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Calendar calendar= Calendar.getInstance();
        final int startYear = calendar.get(Calendar.YEAR);
        final int startMonth = calendar.get(Calendar.MONTH);
        final int startDay = calendar.get(Calendar.DAY_OF_MONTH);
        final int startHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int startMinute = calendar.get(Calendar.MINUTE);

        eventName = findViewById(R.id.CreateEvent_EventTitle);
        startDateTextView = findViewById(R.id.CreateEvent_StartDate);
        startTimeTextView = findViewById(R.id.CreateEvent_StartTime);
        endTimeTextView = findViewById(R.id.CreateEvent_EndTime);
        endDateTextView = findViewById(R.id.CreateEvent_EndDate);
        MaxParticpant = findViewById(R.id.CreateEvent_MaxParticpants);


        //START DATE TIME PART -------------------------------------------------------------------------------
        startDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(CreateEventActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListenerStartDate,startYear,startMonth,startDay);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListenerStartDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int syear, int smonth, int sdayOfMonth) {
                smonth = smonth+1;
                sDate = sdayOfMonth +"/"+smonth+"/"+syear;
                //eTime = sdayOfMonth +"/"+smonth+"/"+syear;
                startDateTextView.setText(sDate);
                //endDateTextView.setText(sDate);  // it will also set the end date just for convenience for the user
            }
        };

        // Create and show a timePickerDialog when click text.
        startTimeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(CreateEventActivity.this,android.R.style.Theme_Holo_Light_Dialog, setListenerStartTime,startHour,startMinute, true);
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.show();

            }
        });

        //Create a new OnTimeSetListener instance. This listener will be invoked when user click ok button in timePickerDialog.
        setListenerStartTime = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int shour, int sminute) {
                if(shour<10) {
                    strTemp = "0" + shour+":";
                }else{
                    strTemp = shour +":";
                }
                if(sminute<10){
                    strTemp = strTemp+ "0" + sminute;
                }else{
                    strTemp = strTemp + sminute;
                }
                sTime = strTemp;
                strTemp = null;
                startTimeTextView.setText(sTime);    // there will format the showing time to User interface
            }
        };


        // END DATE TIME PART-----------------------------------------------------------------------------
        final int endYear = calendar.get(Calendar.YEAR);
        final int endMonth = calendar.get(Calendar.MONTH);
        final int endDay = calendar.get(Calendar.DAY_OF_MONTH);
        final int endHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int endMinute = calendar.get(Calendar.MINUTE);

        endDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(CreateEventActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListenerEndDate,endYear,endMonth,endDay);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListenerEndDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int eyear, int emonth, int edayOfMonth) {
                emonth = emonth+1;
                eDate = edayOfMonth +"/"+emonth+"/"+eyear;
                endDateTextView.setText(eDate);
            }
        };

        // when user press on the select End Time
        endTimeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(CreateEventActivity.this,android.R.style.Theme_Holo_Light_Dialog, setListenerEndTime,endHour,endMinute, true);
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.show();
            }
        });

        //Create a new OnTimeSetListener instance. This listener will be invoked when user click ok button in DatePickerDialog.
        setListenerEndTime = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int ehour, int eminute) {
                if(ehour<10) {
                    strTemp = "0" + ehour+":";
                }else{
                    strTemp = ehour +":";
                }
                if(eminute<10){
                    strTemp = strTemp+ "0" + eminute;
                }else{
                    strTemp = strTemp + eminute;
                }
                eTime = strTemp;
                strTemp = null;
                endTimeTextView.setText(eTime);    // there will format the showing time to User interface
            }
        };


        // when createEvent button press, it will validate the require field. Once it passed, it will input to the database
        CreateEvent = findViewById(R.id.CreateEvent_button);
        CreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateEventName()  && validateStartDate() && validateStartTime() && validateEndDate() && validateEndTime()){

                    String startDateTimeString = combineDateTime(sDate,sTime);
                    String endDateTimeString = combineDateTime(eDate,eTime);

                    startDateTime = DateTimeFormat(startDateTimeString);
                    endDateTime = DateTimeFormat(endDateTimeString);

                    if(validateDatetime(startDateTime,endDateTime)){
                        Toast.makeText(CreateEventActivity.this, "Event successfully created!!!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), JoinSuccessfullyActivity.class);
                        startActivity(intent);
                        //TODO: input data into database

                        //Event newCreateEvent = new Event(11, eventNameInput,);
                    }else {
                        Toast.makeText(getApplicationContext(),"Start date time cannot later than end date time",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(CreateEventActivity.this, "Event create fail...", Toast.LENGTH_LONG).show();
                }
            }
        });


        // when addLocation button press, it will direct to the pin location activity and return the latitude and longitude
        addLocation = findViewById(R.id.CreateEvent_MapButton);
        addLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });


    }

    // check whether the startdatetime is earlier than the enddatetime
    private  boolean validateDatetime(Date start, Date end){
        if (start.after(end)){
            return false;
        }
        return true;
    }

    // function use for combining the Date and the time
    private String combineDateTime(String date, String time){
         String datetime = date +" "+ time;
        return datetime;
    }

    // function for changing the date type for validation check
    private Date DateTimeFormat(String datetime) {

        Date output = null;
        try {
            output = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return output;
    }

    // function for validate non empty input of Event Name
    private boolean validateEventName() {
        String nameInput = eventName.getText().toString();
        // check if User name field is empty
        if(nameInput.isEmpty()){
            eventName.setError("User Name cannot be empty");
            return false;
        } else{
            eventName.setError(null);
            return true;
        }
    }
    // rest of functions are for checking non-empty input for the datetime and location
    private boolean validateStartDate(){
        if(sDate==null){
            startDateTextView.setError("Start date cannot be empty");
            return false;
        } else{
            startDateTextView.setError(null);
            return true;
        }
    }

    private boolean validateStartTime(){
        if(sTime==null){
            startTimeTextView.setError("Start time cannot be empty");
            return false;
        } else{
            startTimeTextView.setError(null);
            return true;
        }
    }

    private boolean validateEndDate(){
        if(eDate==null){
            endDateTextView.setError("End date cannot be empty");
            return false;
        } else{
            endDateTextView.setError(null);
            return true;
        }
    }

    private boolean validateEndTime(){
        if(eTime==null){
            endTimeTextView.setError("End time cannot be empty");
            return false;
        } else{
            endTimeTextView.setError(null);
            return true;
        }
    }

    private boolean validateLocation(){
        if (longitude ==0 && latitude == 0 ){
            Toast.makeText(getApplicationContext(),"Location not yet chosen!!",Toast.LENGTH_SHORT).show();
            return false;
        }return  true;
    }




}