package com.hfad.materialdesign.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hfad.materialdesign.Fragment.Fragment1;
import com.hfad.materialdesign.Fragment.Fragment2;
import com.hfad.materialdesign.Fragment.Fragment3;
import com.hfad.materialdesign.Fragment.Fragment4;
import com.hfad.materialdesign.Fragment.Fragment5;
import com.hfad.materialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class TabsActivity extends AppCompatActivity
{
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> fragmentList;
    private String[] titles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4", "Tab5"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        initAdapter();

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new FragAdapter(getSupportFragmentManager()));
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //將 TabLayout 與 ViewPage 組合起來
        mTabLayout.setupWithViewPager(mViewPager);

        //為 TabLayout 的 Tab 設置圖標
        TabLayout.Tab tabCall1 = mTabLayout.getTabAt(0);
        tabCall1.setIcon(R.drawable.tabselector);
        TabLayout.Tab tabCall2 = mTabLayout.getTabAt(1);
        tabCall2.setIcon(R.drawable.tabselector);
        TabLayout.Tab tabCall3 = mTabLayout.getTabAt(2);
        tabCall3.setIcon(R.drawable.tabselector);
        TabLayout.Tab tabCall4 = mTabLayout.getTabAt(3);
        tabCall4.setIcon(R.drawable.tabselector);
        TabLayout.Tab tabCall5 = mTabLayout.getTabAt(4);
        tabCall5.setIcon(R.drawable.tabselector);
    }

    private void initAdapter()
    {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());
        fragmentList.add(new Fragment5());
    }

    class FragAdapter extends FragmentPagerAdapter
    {

        public FragAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return fragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return fragmentList.size();
        }

        //返回 TAG 的標題
        @Override
        public CharSequence getPageTitle(int position)
        {
            return titles[position];
        }
    }
}
