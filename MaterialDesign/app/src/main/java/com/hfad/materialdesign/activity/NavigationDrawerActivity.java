package com.hfad.materialdesign.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.hfad.materialdesign.R;

public class NavigationDrawerActivity extends AppCompatActivity
{
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationdrawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //開啟側滑
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        setupDrawerContent(mNavigationView);


    }
    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            //紀錄點擊過的 menu ，下次打開側滑頁面
            private MenuItem mPreMenuItem;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                if (mPreMenuItem != null)
                {
                    mPreMenuItem.setChecked(false);
                }
                item.setCheckable(true);
                mDrawerLayout.closeDrawers();
                mPreMenuItem = item;
                return true;
            }
        });
    }
}
