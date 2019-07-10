package com.example.asmntclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    Button btnAddTeacher, btnAddStudent, btnTeacherDetails, btnStudentDetails,btnRUDTeacher, btnRUDStudent, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnAddTeacher = findViewById(R.id.btnAddTeacher);
        btnAddStudent = findViewById(R.id.btnAddStudent);
        btnTeacherDetails = findViewById(R.id.btnTeacherDetails);
        btnStudentDetails = findViewById(R.id.btnStudentDetails);
        btnRUDTeacher = findViewById(R.id.btnRUDTeacher);
        btnRUDStudent = findViewById(R.id.btnRUDStudent);
        btnBack = findViewById(R.id.btnBack);


        btnAddTeacher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Dashboard.this,RegisterTeacher.class);
                startActivity(intent);
            }
        });

        btnAddStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Dashboard.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnTeacherDetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Dashboard.this,ViewDetailOfTeacherActivity.class);
                startActivity(intent);
            }
        });

        btnStudentDetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Dashboard.this,ViewDetailOfStudent.class);
                startActivity(intent);
            }
        });

        btnRUDTeacher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Dashboard.this, RUDStudentActivity.class);
                startActivity(intent);
            }
        });

        btnRUDStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Dashboard.this, RUDTeacherActivity.class);
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Dashboard.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
