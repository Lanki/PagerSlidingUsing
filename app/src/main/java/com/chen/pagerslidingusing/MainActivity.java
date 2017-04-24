package com.chen.pagerslidingusing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    PagerSlidingTabStrip tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);
    }

    private class myPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

        private final int[] ICONS = {R.drawable.icr_account_36dp,
                R.drawable.ic_hdr_on_black_36dp, R.drawable.ic_tag_faces_black_36dp};

        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1Activity();
                case 1:
                    return new Fragment2Activity();
                case 2:
                    return new Fragment3Activity();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return ICONS.length;
        }

        @Override
        public int getPageIconResId(int position) {
            return ICONS[position];
        }
    }
}
