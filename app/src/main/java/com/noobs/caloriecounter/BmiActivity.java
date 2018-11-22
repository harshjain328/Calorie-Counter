package com.noobs.caloriecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BmiActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final EditText height = findViewById(R.id.height_input);
        final EditText weight = findViewById(R.id.weight_input);
        final TextView bmi_result = findViewById(R.id.bmi_result);
        Button button = findViewById(R.id.bmi_calc_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (height.getText().toString().length() < 1)
                {
                    sendToast("You must enter your height!");
                    // Abort the onClick if null
                    return;
                }
                if (weight.getText().toString().length() < 1)
                {
                    sendToast("You must enter your weight, sorry!");
                    // Abort the onClick if null
                    return;
                }
                float h = Float.valueOf(height.getText().toString());
                float w = Float.valueOf(weight.getText().toString());

                float BMI = w / (h * h) * 10000;

                // Set the bmi_result view item of the value of our BMI
                bmi_result.setText(String.valueOf(BMI));
            }
        });
    }

    public void sendToast(String msg)
    {
        // Get the message from our method call
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(BmiActivity.this, text, duration);
        toast.show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            finish();
            Intent home = new Intent(BmiActivity.this,HomeActivity.class);
            startActivity(home);
        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_prog) {
            finish();
            Intent prog=new Intent(BmiActivity.this,NutritionActivity.class);
            startActivity(prog);
        } else if (id == R.id.nav_goal) {
            finish();
            Intent goal=new Intent(BmiActivity.this,GoalActivity.class);
            startActivity(goal);
        } else if (id == R.id.nav_nut) {
            finish();
            Intent nut = new Intent(BmiActivity.this,ProgressActivity.class);
            startActivity(nut);
        } else if (id == R.id.nav_bmi) {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_settings) {

        }
        else if (id == R.id.nav_bar) {
            finish();
            Intent bar = new Intent(BmiActivity.this,BarcodeActivity.class);
            startActivity(bar);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
