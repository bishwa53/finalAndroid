package com.example.asmntclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import URL.Url;
import adapter.AttendanceAdapter;
import adapter.StudentAdapter;
import api.AttendanceAPI;
import model.Attendance;
import model.student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAttendanceActivity extends AppCompatActivity {
    private RecyclerView recyclerViewAttendance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        recyclerViewAttendance = findViewById(R.id.recyclerViewAttendance);
        AttendanceAPI attendanceAPI = Url.getInstance().create(AttendanceAPI.class);

        Call<List<Attendance>> listCall = attendanceAPI.getAttendace();
        listCall.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call, Response<List<Attendance>> response) {
                if (!response.isSuccessful()){
//                    use snackbar here
                    Toast.makeText(ViewAttendanceActivity.this, "Code : "+ response.code() , Toast.LENGTH_SHORT).show();
                }
                List<Attendance> items =  response.body();
                AttendanceAdapter attendanceAdapter = new AttendanceAdapter(items,ViewAttendanceActivity.this);
                recyclerViewAttendance.setAdapter(attendanceAdapter);
                recyclerViewAttendance.setLayoutManager(new LinearLayoutManager(ViewAttendanceActivity.this));
            }

            @Override
            public void onFailure(Call<List<Attendance>> call, Throwable t) {
                Toast.makeText(ViewAttendanceActivity.this, "Error : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });

    }
}
