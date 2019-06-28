package com.example.asmntclass;

import android.content.Intent;
import android.graphics.Color;
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

import model.student;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegisterStudent;
    EditText etFname, etLname, etContact, etAddress, etUsername, etPassword;
    Spinner spnClass;
    String year;
    private String[] yearString = new String[] {"1st","2nd","3rd"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spnClass = findViewById(R.id.spnClass);
        etFname = findViewById(R.id.etFname);
        etLname = findViewById(R.id.etLname);
        etContact = findViewById(R.id.etContact);
        etAddress = findViewById(R.id.etAddress);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnRegisterStudent = findViewById(R.id.btnRegisterStudent);

        spnClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                year = (String) spnClass.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapter_year = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, yearString);
        adapter_year
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnClass.setAdapter(adapter_year);

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

                    student student = new student();

                    student.setStudent_firstname(first_name);
                    student.setStudent_lastname(last_name);
                    student.setStudent_contactnumber(phone_no);
                    student.setStudent_address(address);
                    student.setStudent_class(year);
                    student.setStudent_username(userName);
                    student.setStudent_password(passWord);


                    Intent intent =new Intent(RegisterActivity.this,Dashboard.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "student added successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
