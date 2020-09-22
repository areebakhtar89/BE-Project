package com.example.chintan.myapplication;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chintan.myapplication.ConnectionM.Connection;
import com.example.chintan.myapplication.Data.Userdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    Button btnregis;
    EditText editTextname, editTextemailid, editTextcontact, editTextaddress, editTextpassword, editTextrepassword;
    ProgressDialog dg;
    int resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnregis = findViewById(R.id.btnregister);

       /* editTextname = findViewById(R.id.editname);*/
        editTextname=findViewById(R.id.editname);
        editTextemailid = findViewById(R.id.editemail);
        editTextcontact = findViewById(R.id.editcontact);
        editTextaddress = findViewById(R.id.editaddress);
        editTextpassword = findViewById(R.id.editpassword);
        editTextrepassword = findViewById(R.id.editrepassword);

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatesubmit();
            }
        });


    }

    public void validatesubmit() {
        final String name = editTextname.getText().toString().trim(),
                email = editTextemailid.getText().toString().trim(),
                cont_no = editTextcontact.getText().toString().trim(),
                address = editTextaddress.getText().toString().trim(),
                password = editTextpassword.getText().toString().trim(),
                repassword = editTextrepassword.getText().toString().trim();


        final EditText[] Alledit = {editTextname, editTextemailid, editTextcontact, editTextaddress, editTextpassword, editTextrepassword};
        for (EditText edit : Alledit) {
            if (edit.getText().toString().trim().length() == 0) {
                edit.setError("Empty Field");
                edit.requestFocus();
            }
        }

        if (!isValidPh(cont_no)) {
            editTextcontact.setError("Invalid Contact Number");
        } else if (!isValidEmail(email)) {
            editTextemailid.setError("Invalid Mail Id");
        } else if (!isValidUname(name)) {
            editTextname.setError("Invalid Name");
        } else if (password.length() < 4) {
            editTextpassword.setError("Password Length must be atleast 4");
        } else if (!password.equals(repassword)) {
            editTextrepassword.setError("Re-Password is not match ");
        } else {

            Userdata.setName(name);
            Userdata.setEmail(email);
            Userdata.setContact(cont_no);

            Userdata.setAddress(address);
            Userdata.setPassword(password);
            Userdata.setRepassword(repassword);

            register();
        }



    }

    public void register() {
        final Connection conn = new Connection();
        if (Connection.checkNetworkAvailable(RegistrationActivity.this)) {
            dg = new ProgressDialog(RegistrationActivity.this);
            dg.setMessage("Processing ....");
            dg.show();

            Thread tthread = new Thread() {
                @Override
                public void run() {
                    try {
                        resp = conn.register();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    hd.sendEmptyMessage(0);

                }
            };
            tthread.start();
        } else {
            Toast.makeText(RegistrationActivity.this,"Sorry no network access.", Toast.LENGTH_LONG).show();
        }
    }

    public Handler hd = new Handler() {
        public void handleMessage(Message msg) {

            if (dg.isShowing())
                dg.dismiss();

            switch (resp) {
                case 1:
                    Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_LONG).show();
                    finish();
                    break;

                case 2:
                    Toast.makeText(getApplicationContext(), "Contact or Mail Id already exists", Toast.LENGTH_LONG).show();
                    break;

                case 3:
                    Toast.makeText(getApplicationContext(), "Try Later", Toast.LENGTH_LONG).show();
                    break;

                case 0:
                    Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };


    private boolean isValidPh(String ph) {
        //^[7-9][0-9]{9}$
        String EMAIL_PATTERN = "^[7-9][0-9]{9}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(ph);
        return matcher.matches();
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidUname(String name) {
        String N_Pattern = "^([A-Za-z\\+]+[A-Za-z0-9]{1,10})$";
        Pattern pattern = Pattern.compile(N_Pattern);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }



}
