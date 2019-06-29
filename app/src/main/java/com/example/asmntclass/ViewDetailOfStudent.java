package com.example.asmntclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import URL.Url;
import adapter.StudentAdapter;
import adapter.TeacherAdapter;
import api.AttendanceAPI;
import model.Teacher;
import model.student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewDetailOfStudent extends AppCompatActivity {

    private RecyclerView recyclerViewListStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail_of_student);

        recyclerViewListStudent = findViewById(R.id.recyclerViewStudent);

        AttendanceAPI attendanceAPI = Url.getInstance().create(AttendanceAPI.class);

        Call<List<student>> listCall = attendanceAPI.getStudent();


        listCall.enqueue(new Callback<List<student>>() {
            @Override
            public void onResponse(Call<List<student>> call, Response<List<student>> response) {
                if (!response.isSuccessful()){
//                    use snackbar here
                    Toast.makeText(ViewDetailOfStudent.this, "Code : "+ response.code() , Toast.LENGTH_SHORT).show();
                }
                List<student> items =  response.body();
                StudentAdapter studetAdapter = new StudentAdapter(items,ViewDetailOfStudent.this);
                recyclerViewListStudent.setAdapter(studetAdapter);
                recyclerViewListStudent.setLayoutManager(new LinearLayoutManager(ViewDetailOfStudent.this));
            }
            @Override
            public void onFailure(Call<List<student>> call, Throwable t) {
                Toast.makeText(ViewDetailOfStudent.this, "Error : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
