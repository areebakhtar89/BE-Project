package com.example.chintan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.chintan.myapplication.Data.selectrange;

public class setrangeActivity extends AppCompatActivity {

    NumberPicker NP;
    Button btnsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setrange);
        btnsubmit=findViewById(R.id.btnsubmit);

        NP=findViewById(R.id.numberPicker1);
        NP.setMaxValue(10);
        NP.setMinValue(1);
        NP.setWrapSelectorWheel(false);
        NP.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                String range= (String.valueOf(newVal));
                selectrange.setRange(newVal);
            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(setrangeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
