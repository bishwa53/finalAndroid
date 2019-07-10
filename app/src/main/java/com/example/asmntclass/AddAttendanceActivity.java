package com.example.asmntclass;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import adapter.StudentAdapter;
import model.Attendance;
import model.student;

public class AddAttendanceActivity extends AppCompatActivity {
    String status="P";
    Button attendanceSubmitButton;
    private List<student> studentList;
    private Context context;
    RadioGroup radioGroup;
    RadioButton PresentradioButton, AbsentradioButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        PresentradioButton = (RadioButton) findViewById(R.id.PresentradioButton);
        AbsentradioButton = (RadioButton) findViewById(R.id.AbsentradioButton);
        attendanceSubmitButton = (Button) findViewById(R.id.attendanceSubmitButton);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.PresentradioButton){
                    status = "P";

                }else if (checkedId==R.id.AbsentradioButton){
                    status = "A";

                }
                else {

                }
            }

        });
        AbsentradioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Attendance attendance = new Attendance();

            }
        });





    }
}
