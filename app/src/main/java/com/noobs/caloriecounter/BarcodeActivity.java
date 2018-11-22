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
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BarcodeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        scannerView=new ZXingScannerView(BarcodeActivity.this);
        setContentView(scannerView);
        scannerView.setResultHandler(BarcodeActivity.this);
        scannerView.startCamera();
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
    public void onPause(){
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(BarcodeActivity.this,result.getText(),Toast.LENGTH_LONG).show();
        finish();
        Intent home = new Intent(BarcodeActivity.this,HomeActivity.class);
        startActivity(home);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            finish();
            Intent bar = new Intent(BarcodeActivity.this,HomeActivity.class);
            startActivity(bar);
        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_prog) {
            finish();
            Intent prog=new Intent(BarcodeActivity.this,NutritionActivity.class);
            startActivity(prog);
        } else if (id == R.id.nav_goal) {
            Intent goal=new Intent(BarcodeActivity.this,GoalActivity.class);
            startActivity(goal);
            finish();
        } else if (id == R.id.nav_nut) {
            finish();
            Intent nut = new Intent(BarcodeActivity.this,ProgressActivity.class);
            startActivity(nut);
        } else if (id == R.id.nav_bmi) {
            finish();
            Intent bmi = new Intent(BarcodeActivity.this,BmiActivity.class);
            startActivity(bmi);
        } else if (id == R.id.nav_settings) {

        }
        else if (id == R.id.nav_bar) {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
