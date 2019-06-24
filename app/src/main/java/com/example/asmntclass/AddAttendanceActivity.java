package com.example.asmntclass;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AddAttendanceActivity extends AppCompatActivity {
    private ImageButton date;
    private Calendar cal;
    private int day;
    private int month;
    private int dyear;
    private EditText dateEditText;
    Button btnViewAttendance, btnAddAttendance;
    Spinner spnClass,spnsub;
    String year = "1st Year";
    String subject = "API";

    private String[] yearString = new String[] {"1st","2nd","3rd"};
    private String[] subject1stString = new String[] {"SC","MC"};
    private String[] subject2ndString = new String[] {"GT","CN"};
    private String[] subject3rdString = new String[] {"DS","NS"};

    private String[] subjectFinal = new String[] {"M3","DS","M4","CN","M5","NS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);

        spnClass=(Spinner)findViewById(R.id.spnClass);
        spnsub=(Spinner)findViewById(R.id.spnsub);

        ArrayAdapter<String> adapter_year = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yearString);
        adapter_year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnClass.setAdapter(adapter_year);

        spnClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                year =(String) spnClass.getSelectedItem();
                Toast.makeText(getApplicationContext(), "year:"+year, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_subject = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subjectFinal);
        adapter_subject.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnsub.setAdapter(adapter_subject);
        spnsub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                subject =(String) spnsub.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        date = (ImageButton) findViewById(R.id.DateImageButton);
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        dyear = cal.get(Calendar.YEAR);
        dateEditText = (EditText) findViewById(R.id.DateEditText);
        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showDialog(0);

            }
        });

        btnAddAttendance=(Button)findViewById(R.id.btnAddAttendance);
        btnAddAttendance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


            }
        });

        btnViewAttendance=(Button)findViewById(R.id.btnViewAttendance);
        btnViewAttendance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

            }
        });
    }
}
