package com.noobs.caloriecounter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GoalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView lstGoal;
    ArrayList<String> goalLabel,goalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        lstGoal = findViewById(R.id.lst_goal);
        goalLabel=new ArrayList<>();
        goalText=new ArrayList<>();

        goalLabel.add("Starting Weight");
        goalText.add("80 kg on 30-Nov-2016");
        goalLabel.add("Current Weight");
        goalText.add("75");
        goalLabel.add("Goal Weight");
        goalText.add("60");
        goalLabel.add("Weekly Goal");
        goalText.add("Gain 0.75 kg per week");
        goalLabel.add("Activity Level");
        goalText.add("Active");

        mybase obj=new mybase();

        lstGoal.setAdapter(obj);
    }

    class mybase extends BaseAdapter
    {
        LayoutInflater layoutInflater;
        mybase()
        {
            layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return goalLabel.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        class ViewHolder
        {
            TextView label,text;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder v=null;
            if (convertView == null) {
                v=new ViewHolder();
                convertView= layoutInflater.inflate(R.layout.profile_row,null);
                v.label = convertView.findViewById(R.id.textView2);
                v.text = convertView.findViewById(R.id.textView3);
                convertView.setTag(v);
            }
            else {
                v=(ViewHolder) convertView.getTag();
            }

            v.label.setText(goalLabel.get(position));
            v.text.setText(goalText.get(position));
            return convertView;
        }
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
            finish();
            Intent home = new Intent(GoalActivity.this,HomeActivity.class);
            startActivity(home);
        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_prog) {
            finish();
            Intent prog=new Intent(GoalActivity.this,NutritionActivity.class);
            startActivity(prog);
        } else if (id == R.id.nav_goal) {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_nut) {
            finish();
            Intent nut = new Intent(GoalActivity.this,ProgressActivity.class);
            startActivity(nut);
        } else if (id == R.id.nav_bmi) {
            finish();
            Intent bmi = new Intent(GoalActivity.this,BmiActivity.class);
            startActivity(bmi);
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_bar) {
            finish();
            Intent bar = new Intent(GoalActivity.this,BarcodeActivity.class);
            startActivity(bar);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
