package com.example.chintan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chintan.myapplication.Data.Selectedexistingofferdata;

public class SelectedExistingofferActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_existingoffer);

        textView=findViewById(R.id.textofferdesc);
        textView.setText(Selectedexistingofferdata.getSel_eofferdescription());



    }
}
