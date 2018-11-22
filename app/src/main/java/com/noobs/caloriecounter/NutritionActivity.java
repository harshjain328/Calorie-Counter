package com.noobs.caloriecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class NutritionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GraphView graphProg;
    static int count=0;
    LineGraphSeries<DataPoint> series;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        graphProg = findViewById(R.id.graph_prog);
        series=new LineGraphSeries<>();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nutrition, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.addItem:
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(NutritionActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_input, null);
                final EditText edMeas = mView.findViewById(R.id.edMeasure);
                Button btnSet = mView.findViewById(R.id.btnSet);
                Button btnCancel = mView.findViewById(R.id.btnCanel);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                btnSet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!edMeas.getText().toString().isEmpty()){
                            int point = Integer.parseInt(edMeas.getText().toString());
                            series.appendData(new DataPoint(++count,point),true,4);
                            graphProg.addSeries(series);
                            Toast.makeText(NutritionActivity.this, edMeas.getText().toString(), Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
        }
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            finish();
            Intent home = new Intent(NutritionActivity.this,HomeActivity.class);
            startActivity(home);
        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_prog) {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_goal) {
            finish();
            Intent goal=new Intent(NutritionActivity.this,GoalActivity.class);
            startActivity(goal);
        } else if (id == R.id.nav_nut) {
            finish();
            Intent nut=new Intent(NutritionActivity.this,ProgressActivity.class);
            startActivity(nut);
        } else if (id == R.id.nav_bmi) {
            finish();
            Intent bmi = new Intent(NutritionActivity.this,BmiActivity.class);
            startActivity(bmi);
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_bar) {
            finish();
            Intent bar = new Intent(NutritionActivity.this,BarcodeActivity.class);
            startActivity(bar);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
