package com.noobs.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegGoalActivity extends AppCompatActivity {

    Button next,prev;
    RadioGroup rgrpGoal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_goal);

        Intent prevInt = getIntent();
        final String name = prevInt.getStringExtra("Name");
        final String email = prevInt.getStringExtra("Email");
        final String pass = prevInt.getStringExtra("Pass");
        final String dob = prevInt.getStringExtra("DOB");
        final String hgt = prevInt.getStringExtra("Height");
        final String wgt = prevInt.getStringExtra("Weight");
        final String gender = prevInt.getStringExtra("Gender");


        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btn_prev);
        rgrpGoal = findViewById(R.id.rgrpGoal);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rgrpGoal.getCheckedRadioButtonId()==R.id.rbtnMaintain){
                    Intent nxt = new Intent(RegGoalActivity.this,RegActivity.class);
                    nxt.putExtra("Name",name);
                    nxt.putExtra("Email",email);
                    nxt.putExtra("Pass",pass);
                    nxt.putExtra("DOB",dob);
                    nxt.putExtra("Height",hgt);
                    nxt.putExtra("Weight",wgt);
                    nxt.putExtra("Gender",gender);
                    nxt.putExtra("Goal","Maintain");
                    startActivity(nxt);
                }
                else {
                    Intent nxt = new Intent(RegGoalActivity.this, RegGoalWeightActivity.class);
                    nxt.putExtra("Name", name);
                    nxt.putExtra("Email", email);
                    nxt.putExtra("Pass", pass);
                    nxt.putExtra("DOB", dob);
                    nxt.putExtra("Height", hgt);
                    nxt.putExtra("Weight", wgt);
                    nxt.putExtra("Gender", gender);
                    if(rgrpGoal.getCheckedRadioButtonId()==R.id.rbtnLose)
                        nxt.putExtra("Goal","Lose");
                    else
                        nxt.putExtra("Goal","Gain");
                    startActivity(nxt);
                }
            }
        });
    }
}
