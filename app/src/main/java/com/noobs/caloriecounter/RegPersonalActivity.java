package com.noobs.caloriecounter;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class RegPersonalActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    EditText dob,name,email,pass;
    Button next,prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_personal);

        dob = findViewById(R.id.edDOB);
        name = findViewById(R.id.edName);
        email = findViewById(R.id.edEmail);
        pass = findViewById(R.id.edPass);
        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btn_prev);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int year=1990;
                int month=0;
                int day=1;
                DatePickerDialog datePickerDialog=new DatePickerDialog(RegPersonalActivity.this,RegPersonalActivity.this,year,month,day);
                datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis());
                datePickerDialog.show();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Isvalidate()) {
                    Intent nxt = new Intent(RegPersonalActivity.this, RegHeightActivity.class);
                    nxt.putExtra("Name",name.getText().toString());
                    nxt.putExtra("Email",email.getText().toString());
                    nxt.putExtra("Pass",pass.getText().toString());
                    nxt.putExtra("DOB",dob.getText().toString());
                    startActivity(nxt);
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean Isvalidate(){
        boolean isvalidate = true;
        if(TextUtils.isEmpty(name.getText().toString()))
        {
            name.setError("Please enter your name!");
            isvalidate = false;
        }
        if(TextUtils.isEmpty(email.getText().toString()))
        {
            email.setError("Please enter valid Email ID!");
            isvalidate = false;
        }
        if(TextUtils.isEmpty(pass.getText().toString()))
        {
            pass.setError("Please enter password!");
            isvalidate = false;
        }
        if(TextUtils.isEmpty(dob.getText().toString()))
        {
            dob.setError("Please select date of birth!");
            isvalidate = false;
        }
        return isvalidate;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dob.setText(year+"-"+(month+1)+"-"+dayOfMonth);
    }
}
