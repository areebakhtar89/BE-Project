package com.example.chintan.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.chintan.myapplication.ConnectionM.Connection;
import com.example.chintan.myapplication.Data.Userdata;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {


    ProgressDialog progressDialog;
    int resp;

    Button buttonlogin,buttonregister;
    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editText1=findViewById(R.id.editemail);
        editText2=findViewById(R.id.editpassword);
        buttonregister=findViewById(R.id.btnregistration);
        buttonlogin=findViewById(R.id.btnlogin);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }


    public void login() {

        if (editText1.getText().toString().equals("") || editText2.getText().toString().equals(""))
        {
            android.app.AlertDialog alert = new android.app.AlertDialog.Builder(LoginActivity.this).create();
            alert.setTitle("Enter All Details");
            alert.setMessage("All Fields Are Mandatory");
            alert.show();
        }
        else
        {
            final String email=editText1.getText().toString();
            final String pass=editText2.getText().toString();
            final Connection conn = new Connection();
            if (conn.checkNetworkAvailable(LoginActivity.this)) {
                progressDialog = new ProgressDialog(LoginActivity.this);

                progressDialog.show();
                Thread th1 = new Thread() {
                    @Override
                    public void run() {
                        try {
                            int i = conn.authUser(LoginActivity.this,email,pass);
                            resp = i;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        hd.sendEmptyMessage(0);

                    }
                };
                th1.start();
            } else {
                Toast.makeText(LoginActivity.this, "Sorry no network access.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public Handler hd = new Handler() {
        public void handleMessage(Message msg) {
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            switch (resp) {
                case 1:
                    editText1.setText("");
                    editText2.setText("");

                    Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();
                    Intent intadd=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intadd);
                    break;

                case 2:
                    editText1.setText("");
                    editText2.setText("");
                    Toast.makeText(getApplicationContext(), "Invalid Mail or Password", Toast.LENGTH_LONG).show();
                    break;
                case 0:
                    Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
}
