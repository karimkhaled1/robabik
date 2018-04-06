package com.example.karim.robabikia;

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
    public static int pagePostion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView =  findViewById(R.id.nav_view);
        mViewPager = findViewById(R.id.pager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
             pagePostion=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        sectionPageAdapter.addFragment(new SectionFragment(),"page 1");
        sectionPageAdapter.addFragment(new SectionFragment(),"page 2");
        sectionPageAdapter.addFragment(new SectionFragment(),"page 3");
        sectionPageAdapter.addFragment(new SectionFragment(),"page 4");

        mViewPager.setAdapter(sectionPageAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mViewPager);
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


        public void addFragment(Fragment fragment, String s) {
            mfragmentList.add(fragment);
            mfragmentListtitle.add(s);
        }

        public SectionPageAdapter(FragmentManager fm) {
            super(fm);
        }

        // This determines the fragment for each tab
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new SectionFragment();
            } else if (position == 1) {
                return new SectionFragment();
            }
            else if (position == 2) {
                return new SectionFragment();
            }
            else if (position == 3) {
                return new SectionFragment();
            }

            return null;
        }
        // This determines the number of tabs
        @Override
        public int getCount() {
            return 4;
        }

        // This determines the title for each tab
        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            switch (position) {
                case 0:
                    return "entertainment general";
                case 1:
                    return "health";
                case 2:
                    return "technology";
                case 3:
                    return "sports";


            }
            return null;
        }
    }
}
