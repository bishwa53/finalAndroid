package com.example.asmntclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherActivity extends AppCompatActivity {
    Button btnAddAttendance, btnViewAttendance,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);


                btnAddAttendance = findViewById(R.id.btnAddAttendance);
                btnViewAttendance = findViewById(R.id.btnViewAttendance);
                btnBack = findViewById(R.id.btnBack);

        btnAddAttendance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(TeacherActivity.this,AddAttendanceActivity.class);
                startActivity(intent);
            }
        });

        btnViewAttendance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(TeacherActivity.this,ViewAttendanceActivity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(TeacherActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
