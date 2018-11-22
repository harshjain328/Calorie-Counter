package com.noobs.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegGoalWeightActivity extends AppCompatActivity {

    Button next,prev;
    EditText goalWeight;
    RadioButton rbtn25,rbtn50,rbtn1;
    RadioGroup rgrpGoal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_goal_weight);

        Intent prevInt = getIntent();
        final String name = prevInt.getStringExtra("Name");
        final String email = prevInt.getStringExtra("Email");
        final String pass = prevInt.getStringExtra("Pass");
        final String dob = prevInt.getStringExtra("DOB");
        final String hgt = prevInt.getStringExtra("Height");
        final String wgt = prevInt.getStringExtra("Weight");
        final String gender = prevInt.getStringExtra("Gender");
        final String goal = prevInt.getStringExtra("Goal");

        rgrpGoal = findViewById(R.id.rgrpGoal);
        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btn_prev);
        rbtn1 = findViewById(R.id.rbtn1);
        rbtn25 = findViewById(R.id.rbtn25);
        rbtn50 = findViewById(R.id.rbtn50);
        goalWeight = findViewById(R.id.edGoalWeight);

        rbtn1.setText(goal+" "+rbtn1.getText().toString());
        rbtn25.setText(goal+" "+rbtn25.getText().toString());
        rbtn50.setText(goal+" "+rbtn50.getText().toString());

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
                    Intent nxt = new Intent(RegGoalWeightActivity.this, RegActivity.class);
                    nxt.putExtra("Name", name);
                    nxt.putExtra("Email", email);
                    nxt.putExtra("Pass", pass);
                    nxt.putExtra("DOB", dob);
                    nxt.putExtra("Height", hgt);
                    nxt.putExtra("Weight", wgt);
                    nxt.putExtra("Gender", gender);
                    nxt.putExtra("Goal", goal);
                    if (rgrpGoal.getCheckedRadioButtonId() == R.id.rbtn1)
                        nxt.putExtra("Goal Week", "1");
                    else if (rgrpGoal.getCheckedRadioButtonId() == R.id.rbtn25)
                        nxt.putExtra("Goal Week", "0.25");
                    else
                        nxt.putExtra("Goal Week", "0.5");
                    nxt.putExtra("Goal Weight", goalWeight.getText().toString());
                    startActivity(nxt);
                }
            }
        });
    }

    private boolean Isvalidate(){
        boolean isvalidate = true;
        if(TextUtils.isEmpty(goalWeight.getText().toString()))
        {
            goalWeight.setError("Please enter valid Goal Weight!");
            isvalidate = false;
        }
        return isvalidate;
    }
}
