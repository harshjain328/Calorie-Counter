package com.noobs.caloriecounter;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private float[] yData = {200f,400f,1600f};
    private String[] xData = {"Fats", "Carbs" , "Nutrients"};
    PieChart pieChart;
    TextView txtName,txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Calorie Counter");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        txtName = findViewById(R.id.txt_user_name);
//        txtEmail = findViewById(R.id.txt_user_email);
//        txtName.setText("Harsh");
//        txtEmail.setText("temp@test.com");

        pieChart = findViewById(R.id.idPieChart);
        Description description=new Description();
        description.setText("");
        pieChart.setDescription(description);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);

        addDataSet();
    }

    private void addDataSet() {
        ArrayList<PieEntry> yEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            yEntrys.add(new PieEntry(yData[i] , xData[i]));
        }

//      create the data set
//        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Calorie budget");
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "");
        pieDataSet.setSliceSpace(15);
        pieDataSet.setValueTextSize(15);
        pieDataSet.setValueTextColor(Color.WHITE);

//      add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#9e0039"));
        colors.add(Color.parseColor("#b7b7b7"));
        colors.add(Color.parseColor("#533573"));

        pieDataSet.setColors(colors);
//      pieDataSet.setColor(Color.WHITE);

//      add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setTextSize(15f);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_prog) {
            finish();
            Intent prog=new Intent(HomeActivity.this,NutritionActivity.class);
            startActivity(prog);
        } else if (id == R.id.nav_goal) {
            finish();
            Intent goal=new Intent(HomeActivity.this,GoalActivity.class);
            startActivity(goal);
        } else if (id == R.id.nav_nut) {
            finish();
            Intent nut = new Intent(HomeActivity.this,ProgressActivity.class);
            startActivity(nut);
        } else if (id == R.id.nav_bmi) {
            finish();
            Intent bmi = new Intent(HomeActivity.this,BmiActivity.class);
            startActivity(bmi);
        } else if (id == R.id.nav_settings) {

        }
        else if (id == R.id.nav_bar) {
            finish();
            Intent bar = new Intent(HomeActivity.this,BarcodeActivity.class);
            startActivity(bar);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
