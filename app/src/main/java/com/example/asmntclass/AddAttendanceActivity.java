package com.example.asmntclass;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
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

import URL.Url;
import adapter.StudentAdapter;
import api.AttendanceAPI;
import model.Attendance;
import model.student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAttendanceActivity extends AppCompatActivity implements View.OnClickListener {
//    String status="P";
//    Button attendanceSubmitButton;
//    private List<student> studentList;
//    private Context context;
//    RadioGroup radioGroup;
//    RadioButton PresentradioButton, AbsentradioButton;

    private EditText studentId,status;
    private Button btnAdd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);

        studentId = findViewById(R.id.etStudentId);
        status = findViewById(R.id.etStudentStatus);
        btnAdd = findViewById(R.id.btnAttendanceAdd);

        btnAdd.setOnClickListener(this);

//        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        PresentradioButton = (RadioButton) findViewById(R.id.PresentradioButton);
//        AbsentradioButton = (RadioButton) findViewById(R.id.AbsentradioButton);
//        attendanceSubmitButton = (Button) findViewById(R.id.attendanceSubmitButton);
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId==R.id.PresentradioButton){
//                    status = "P";
//
//                }else if (checkedId==R.id.AbsentradioButton){
//                    status = "A";
//
//                }
//                else {
//
//                }
//            }
//
//        });
//        AbsentradioButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Attendance attendance = new Attendance();
//
//            }
//        });





    }

    @Override
    public void onClick(View view) {
        String theStudentid = studentId.getText().toString();
        String theStatus = status.getText().toString();
        if( theStudentid.length() > 0 && theStatus.length() > 0 ){

            AttendanceAPI attendanceAPI = Url.getInstance().create(AttendanceAPI.class);
            Call<Void> voidCall = attendanceAPI.addAttendance(theStatus,theStudentid);

            voidCall.enqueue(new Callback<Void>() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    All.showNotification(getApplicationContext(),"Attendance Notification","Attendance added");
                    Toast.makeText(AddAttendanceActivity.this,"Attendance added",Toast.LENGTH_LONG ).show();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });

        }else{
            Toast.makeText(AddAttendanceActivity.this,"Please enter all values",Toast.LENGTH_LONG ).show();
        }
    }
}
