package com.hfad.materialdesign.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.hfad.materialdesign.R;

public class SearchActivity extends AppCompatActivity
{
    private androidx.appcompat.widget.SearchView search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        this.search = (SearchView) findViewById(R.id.search);
        SearchManager mSearchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search.setSearchableInfo(mSearchManager.getSearchableInfo(getComponentName()));
        /**
                 *  接收查詢 Activity 傳過來的數據
                 */
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query = intent.getStringExtra(SearchManager.QUERY);
            show(query);
        }
        // 開啟輸入文字的清除與查詢
        search.setSubmitButtonEnabled(true);
        // 設置 hint
        search.setQueryHint("请输入关键字");
        // 設置默認開啟
        search.onActionViewExpanded();

        //查詢監聽
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            //點擊查詢按鈕
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                show(query);
                return true;
            }
            //查詢框文字發送發生變化
            @Override
            public boolean onQueryTextChange(String newText)
            {
                return false;
            }
        });
    }

    private void show(String str)
    {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
