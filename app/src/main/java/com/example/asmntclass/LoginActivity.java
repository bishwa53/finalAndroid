package com.example.asmntclass;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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


public class LoginActivity extends Activity  {
    Button btnLogin,btnCancel;
    EditText etUsername,etPassword;
    Spinner spinnerloginas;
    String userrole;

    private String[] userRoleString = new String[] { "admin", "student", "teacher"};

    TextView tvCount;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        tvCount = (TextView)findViewById(R.id.tvCount);
        spinnerloginas=(Spinner)findViewById(R.id.spinnerloginas);
        tvCount.setVisibility(View.GONE);

        spinnerloginas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                     @Override
                                                     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                         ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                                                         userrole =(String) spinnerloginas.getSelectedItem();
                                                     }

                                                     @Override
                                                     public void onNothingSelected(AdapterView<?> parent) {

                                                     }
                                                 });
        ArrayAdapter<String> adapter_role = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, userRoleString);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerloginas.setAdapter(adapter_role);



        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if(userrole.equals("admin"))
                {

                    String user_name = etUsername.getText().toString();
                    String pass_word = etPassword.getText().toString();

                    if (TextUtils.isEmpty(user_name))
                    {
                        etUsername.setError("Invalid User Name");
                    }
                    else if(TextUtils.isEmpty(pass_word))
                    {
                        etPassword.setError("enter password");
                    }
                    else
                    {
                        if(user_name.equals("admin") & pass_word.equals("admin123")){
                            Intent intent =new Intent(LoginActivity.this,Dashboard.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                else
                {
                    String user_name = etUsername.getText().toString();
                    String pass_word = etPassword.getText().toString();

                    if (TextUtils.isEmpty(user_name))
                    {
                        etUsername.setError("Invalid User Name");
                    }
                    else if(TextUtils.isEmpty(pass_word))
                    {
                        etPassword.setError("enter password");
                    }

                    Toast.makeText(LoginActivity.this, "I am here", Toast.LENGTH_SHORT).show();
                }

                tvCount.setVisibility(View.VISIBLE);
                counter--;
                tvCount.setText(Integer.toString(counter));

                if (counter == 0) {
                    btnLogin.setEnabled(false);
                }

            }
        });





        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
