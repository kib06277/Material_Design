package com.hfad.materialdesign.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hfad.materialdesign.Adapter.NormalRecyclerViewAdapter;
import com.hfad.materialdesign.R;

public class FabActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        RecyclerView mRecycerView = (RecyclerView) findViewById(R.id.lvToDoList);
        //設置線性布局
        mRecycerView.setLayoutManager(new LinearLayoutManager(this));
        mRecycerView.setAdapter(new NormalRecyclerViewAdapter(this));
    }
}
