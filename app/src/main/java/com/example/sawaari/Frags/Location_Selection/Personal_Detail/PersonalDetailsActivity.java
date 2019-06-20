package com.example.sawaari.Frags.Location_Selection.Personal_Detail;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.sawaari.Frags.Location_Selection.LocationSelector;
import com.example.sawaari.Frags.Location_Selection.Tab1;
import com.example.sawaari.Frags.Location_Selection.Tab2;
import com.example.sawaari.R;

public class PersonalDetailsActivity extends AppCompatActivity implements Detail_Tab1.OnFragmentInteractionListener, Detail_Tab2.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText(getString(R.string.tab3)));
        tabs.addTab(tabs.newTab().setText(getString(R.string.tab4)));

        final ViewPager viewPager = findViewById(R.id.view_pager);
        final DetailPagerAdapter adapter = new DetailPagerAdapter(getSupportFragmentManager(), tabs.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
    public void onFragmentInteraction(Uri uri) {

    }

    public class DetailPagerAdapter extends FragmentStatePagerAdapter {

        int noOfTabs;

        public DetailPagerAdapter(android.support.v4.app.FragmentManager fm, int NoOfTabs) {
            super(fm);
            this.noOfTabs = NoOfTabs;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Detail_Tab1 tab1 = new Detail_Tab1();
                    return tab1;

                case 1:
                    Detail_Tab2 tab2 = new Detail_Tab2();
                    return tab2;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return noOfTabs;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
