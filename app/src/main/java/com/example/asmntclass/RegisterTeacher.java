package com.example.asmntclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Instant;

import model.Teacher;

public class RegisterTeacher extends AppCompatActivity {

    EditText etFname,etLname, etContact, etAddress, etUsername, etPassword;
    Button btnRegisterTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_teacher);

        etFname = findViewById(R.id.etFname);
        etLname = findViewById(R.id.etLname);
        etContact = findViewById(R.id.etContact);
        etAddress = findViewById(R.id.etAddress);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnRegisterTeacher = findViewById(R.id.btnRegisterStudent);

        btnRegisterTeacher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

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
                    etUsername.setError("please enter username");
                }
                else if (TextUtils.isEmpty(passWord)) {
                    etPassword.setError("enter password");
                }

                else {
                    Teacher teacher = new Teacher();
                    teacher.getTeacher_firstname();
                    teacher.getTeacher_lastname();
                    teacher.getTeacher_contactnumber();
                    teacher.getTeacher_address();
                    teacher.getTeacher_username();
                    teacher.getTeacher_password();

                    Intent intent =new Intent(RegisterTeacher.this,Dashboard.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Teacher added sucessfully", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
}
