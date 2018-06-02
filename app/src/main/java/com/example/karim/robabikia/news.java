package com.example.karim.robabikia;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class news extends AppCompatActivity
        {

    private SectionPageAdapter sectionPageAdapter;
    private ViewPager mViewPager;
    static int index;
         private static TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.BLUE);
        setSupportActionBar(toolbar);
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView =  findViewById(R.id.nav_view);
        mViewPager = findViewById(R.id.pager);
        sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        sectionPageAdapter.addFragment(new SectionFragment(),"page 1");
        sectionPageAdapter.addFragment(new SectionFragment(),"page 2");
        sectionPageAdapter.addFragment(new SectionFragment(),"page 3");
        sectionPageAdapter.addFragment(new SectionFragment(),"page 4");
        mViewPager.setAdapter(sectionPageAdapter);
         tabLayout = findViewById(R.id.sliding_tabs);

        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setText("science");
        tabLayout.getTabAt(1).setText("business");
        tabLayout.getTabAt(2).setText("technology");
        tabLayout.getTabAt(3).setText("sports");
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(R.drawable.ic_menu_camera);
        }

        tabLayout.setBackgroundColor(Color.rgb(118,60,77        ));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                index=tab.getPosition();
                Log.e("ssa",index+"");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.news, menu);
        return true;
    }





    public class SectionPageAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mfragmentList = new ArrayList<>();
        private final List<String> mfragmentListtitle = new ArrayList<>();

        public SectionPageAdapter(FragmentManager fm) {
            super(fm);
        }


        public void addFragment(Fragment fragment, String s) {
            mfragmentList.add(fragment);
            mfragmentListtitle.add(s);
        }
        @Override
        public Fragment getItem(int position) {return new SectionFragment();}
        @Override
        public int getCount() {
            return 4;
        }

        // This determines the title for each tab
    }
}
