package com.example.asmntclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;
import URL.Url;
import adapter.TeacherAdapter;
import api.AttendanceAPI;
import model.Teacher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewDetailOfTeacherActivity extends AppCompatActivity {

    private RecyclerView recyclerViewListTeacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail_of_teacher);

        recyclerViewListTeacher = findViewById(R.id.recyclerViewTeacher);

        AttendanceAPI attendanceAPI = Url.getInstance().create(AttendanceAPI.class);

        Call<List<Teacher>> listCall = attendanceAPI.getTeacher();


        listCall.enqueue(new Callback<List<Teacher>>() {
            @Override
            public void onResponse(Call<List<Teacher>> call, Response<List<Teacher>> response) {
                if (!response.isSuccessful()){
//                    use snackbar here
                    Toast.makeText(ViewDetailOfTeacherActivity.this, "Code : "+ response.code() , Toast.LENGTH_SHORT).show();
                }
                List<Teacher> items =  response.body();
                TeacherAdapter teacherAdapter = new TeacherAdapter(items,ViewDetailOfTeacherActivity.this);
                recyclerViewListTeacher.setAdapter(teacherAdapter);
                recyclerViewListTeacher.setLayoutManager(new LinearLayoutManager(ViewDetailOfTeacherActivity.this));
            }
            @Override
            public void onFailure(Call<List<Teacher>> call, Throwable t) {
                Toast.makeText(ViewDetailOfTeacherActivity.this, "Error : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
