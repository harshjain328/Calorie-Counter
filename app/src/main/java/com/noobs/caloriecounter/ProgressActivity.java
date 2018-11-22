package com.noobs.caloriecounter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class ProgressActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Nutrition");
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public static class CalFrag extends Fragment {
        private int[] yData = {500,425,175,300};
        private String[] xData = {"Lunch", "Dinner" , "Breakfast", "Snacks"};
        PieChart pieChart;
        public CalFrag() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static CalFrag newInstance(int sectionNumber) {
            CalFrag fragment = new CalFrag();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_calorie_graph, container, false);
            pieChart = rootView.findViewById(R.id.idPieChart);
            Description description=new Description();
            description.setText("");
            pieChart.setDescription(description);

            pieChart.setRotationEnabled(true);

            pieChart.setHoleRadius(0f);
            pieChart.setTransparentCircleAlpha(0);

            addDataSet();
            return rootView;
        }

        private void addDataSet() {
            ArrayList<PieEntry> yEntrys = new ArrayList<>();

            for(int i = 0; i < yData.length; i++){
                yEntrys.add(new PieEntry(yData[i] , xData[i]));
            }

            PieDataSet pieDataSet = new PieDataSet(yEntrys, "");
            pieDataSet.setSliceSpace(5);
            pieDataSet.setValueTextSize(15);
            pieDataSet.setValueTextColor(Color.WHITE);

            ArrayList<Integer> colors = new ArrayList<>();
            colors.add(Color.parseColor("#613d86"));
            colors.add(Color.parseColor("#2f0743"));
            colors.add(Color.parseColor("#482a57"));
            colors.add(Color.parseColor("#9e0039"));

            pieDataSet.setColors(colors);

            Legend legend = pieChart.getLegend();
            legend.setForm(Legend.LegendForm.CIRCLE);
            legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
            legend.setWordWrapEnabled(true);
            legend.setTextSize(15f);

            PieData pieData = new PieData(pieDataSet);
            pieChart.setData(pieData);
            pieChart.invalidate();
        }
    }

    public static class NutFrag extends Fragment {

        public NutFrag() {
        }
        public static NutFrag newInstance(int sectionNumber) {
            NutFrag fragment = new NutFrag();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_nut, container, false);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return CalFrag.newInstance(position+1);
                case 1:
                    return NutFrag.newInstance(position + 1);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "CALORIES";
                case 1:
                    return "NUTRIENTS";
            }
            return null;
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
            Intent home = new Intent(ProgressActivity.this,HomeActivity.class);
            startActivity(home);
        } else if (id == R.id.nav_diary) {

        } else if (id == R.id.nav_prog) {
            finish();
            Intent prog=new Intent(ProgressActivity.this,NutritionActivity.class);
            startActivity(prog);
        } else if (id == R.id.nav_goal) {
            finish();
            Intent goal=new Intent(ProgressActivity.this,GoalActivity.class);
            startActivity(goal);
        } else if (id == R.id.nav_nut) {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_bmi) {
            finish();
            Intent bmi = new Intent(ProgressActivity.this,BmiActivity.class);
            startActivity(bmi);
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_bar) {
            finish();
            Intent bar = new Intent(ProgressActivity.this,BarcodeActivity.class);
            startActivity(bar);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
