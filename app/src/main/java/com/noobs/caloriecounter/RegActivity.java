package com.noobs.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RegActivity extends AppCompatActivity {

    Button next,prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_activity);

        Intent prevInt = getIntent();
        final String name = prevInt.getStringExtra("Name");
        final String email = prevInt.getStringExtra("Email");
        final String pass = prevInt.getStringExtra("Pass");
        final String dob = prevInt.getStringExtra("DOB");
        final String hgt = prevInt.getStringExtra("Height");
        final String wgt = prevInt.getStringExtra("Weight");
        final String gender = prevInt.getStringExtra("Gender");
        final String goal = prevInt.getStringExtra("Goal");
        String goalWeek = prevInt.getStringExtra("Goal Week");
        String goalWeight = prevInt.getStringExtra("Goal Weight");

        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btn_prev);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
        Date d = null;
        try{
            d = sdf.parse(dob);
        }catch (Exception e){
            e.printStackTrace();
        }

        final int age = getAge(d.getYear(),d.getMonth(),d.getDay());

        double budget = Math.floor(CalculateCalorie(Integer.parseInt(wgt),Integer.parseInt(hgt),age,gender));
        final float bmi = CalculateBmi(Float.valueOf(wgt),Float.valueOf(hgt));

        if(goal.equals("Gain")){
            if(goalWeek.equals("1")){
                budget+=500;
            } else if(goalWeek.equals("0.25"))
                budget+=125;
            else
                budget+=250;
        } else if(goal.equals("Lose")){
            if(goalWeek.equals("1")){
                budget-=500;
            } else if(goalWeek.equals("0.25"))
                budget-=125;
            else
                budget-=250;
        }

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final double finalBudget = budget;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
//                Intent nxt = new Intent(RegActivity.this,HomeActivity.class);
//                startActivity(nxt);
                Toast.makeText(getApplicationContext(), finalBudget +" "+bmi,Toast.LENGTH_LONG).show();
            }
        });
    }

    public int getAge(int year, int month, int day){
        Calendar dob=Calendar.getInstance();
        Calendar today=Calendar.getInstance();

        dob.set(year,month,day);
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if(today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }
        return age-1900;
    }

    public double CalculateCalorie(int weight, int height, int age, String gender){
        double bmr;
        if(gender.equals("Male")){
            bmr = 66.47+(13.75 * weight)+(5.0 * height)-(6.75 * age);
        }
        else
            bmr = 665.09+(9.56 * weight)+(1.84 * height)-(4.67 * age);

        return bmr;
    }

    public float CalculateBmi(float weight,float height){
        float bmi = weight/(height * height) * 10000;

        NumberFormat format = new DecimalFormat("#0.00");
        return Float.valueOf(format.format(bmi));
    }
}
