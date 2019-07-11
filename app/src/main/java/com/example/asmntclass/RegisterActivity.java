package com.example.asmntclass;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import URL.Url;
import api.AttendanceAPI;
import model.student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegisterStudent;
    EditText etFname, etLname, etContact, etAddress, etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFname = findViewById(R.id.etFname);
        etLname = findViewById(R.id.etLname);
        etContact = findViewById(R.id.etContact);
        etAddress = findViewById(R.id.etAddress);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnRegisterStudent = findViewById(R.id.btnRegisterStudent);


        btnRegisterStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //......................................validation
                String first_name = etFname.getText().toString();
                String last_name = etLname.getText().toString();
                String phone_no = etContact.getText().toString();
                String address = etAddress.getText().toString();
                String userName = etUsername.getText().toString();
                String passWord = etPassword.getText().toString();


                if (TextUtils.isEmpty(first_name)) {
                    etFname.setError("please enter firstname");
                }

                else if (TextUtils.isEmpty(last_name)) {
                    etLname.setError("please enter lastname");
                }
                else if (TextUtils.isEmpty(phone_no)) {
                    etContact.setError("please enter phoneno");
                }

                else if (TextUtils.isEmpty(address)) {
                    etAddress.setError("enter address");
                }

                else if (TextUtils.isEmpty(userName)) {
                    etUsername.setError("enter username");
                }

                else if (TextUtils.isEmpty(passWord)) {
                    etPassword.setError("enter password");
                }
                else {
                    student student = new student(first_name,last_name,phone_no,address,userName,passWord);
                    AttendanceAPI attendanceAPI = Url.getInstance().create(AttendanceAPI.class);


                    Call<Void> voidCall = (Call<Void>) attendanceAPI.addStudent(student);

                    voidCall.enqueue(new Callback<Void>() {
                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if (!response.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Code" + response.code(), Toast.LENGTH_SHORT).show();
                                return;
                            }
                            All.showNotification(getApplicationContext(),"Student Notificaiton","Student added");
                            Toast.makeText(RegisterActivity.this, "Added", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });
                }
            }
        });

    }
}
