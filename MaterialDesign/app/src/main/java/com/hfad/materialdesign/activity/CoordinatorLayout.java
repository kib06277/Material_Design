package com.hfad.materialdesign.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.hfad.materialdesign.Adapter.NormalRecyclerViewAdapter;
import com.hfad.materialdesign.R;

public class CoordinatorLayout extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdl);
        RecyclerView rv = (RecyclerView) findViewById(R.id.cdl_recyclerView);
        CollapsingToolbarLayout collapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("Title");

        //設定線性布局
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new NormalRecyclerViewAdapter(this));
    }
}
