package com.noobs.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegHeightActivity extends AppCompatActivity {

    Button next,prev;
    EditText height,weight;
    RadioGroup rgrpGen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_height);

        Intent prevInt = getIntent();
        final String name = prevInt.getStringExtra("Name");
        final String email = prevInt.getStringExtra("Email");
        final String pass = prevInt.getStringExtra("Pass");
        final String dob = prevInt.getStringExtra("DOB");

        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btn_prev);
        height = findViewById(R.id.edHeight);
        weight = findViewById(R.id.edWeight);
        rgrpGen = findViewById(R.id.rgrpGender);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Isvalidate()) {
                    Intent nxt = new Intent(RegHeightActivity.this, RegGoalActivity.class);
                    nxt.putExtra("Name",name);
                    nxt.putExtra("Email",email);
                    nxt.putExtra("Pass",pass);
                    nxt.putExtra("DOB",dob);
                    nxt.putExtra("Height",height.getText().toString());
                    nxt.putExtra("Weight",weight.getText().toString());
                    if(rgrpGen.getCheckedRadioButtonId()==R.id.rbtnFemale)
                        nxt.putExtra("Gender","Female");
                    else
                        nxt.putExtra("Gender","Male");
                    startActivity(nxt);
                }
            }
        });
    }

    private boolean Isvalidate(){
        boolean isvalidate = true;
        if(TextUtils.isEmpty(height.getText().toString()))
        {
            height.setError("Please enter your height!");
            isvalidate = false;
        }
        if(TextUtils.isEmpty(weight.getText().toString()))
        {
            weight.setError("Please enter your weight!");
            isvalidate = false;
        }
        return isvalidate;
    }
}
