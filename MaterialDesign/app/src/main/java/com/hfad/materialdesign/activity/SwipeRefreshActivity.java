package com.hfad.materialdesign.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.hfad.materialdesign.R;
import com.hfad.materialdesign.View.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

public class SwipeRefreshActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,SwipeRefreshView.OnLoadListener
{
    private ListView refresh_lv;
    private SwipeRefreshView refresh_sfl ;
    private int mCount;
    private List<String> mList;
    private StringAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiperefresh);
        refresh_lv = (ListView) findViewById(R.id.refresh_lv);
        refresh_sfl = (SwipeRefreshView) findViewById(R.id.refresh_sfl);
        initData();
        mAdapter = new StringAdapter();
        refresh_lv.setAdapter(mAdapter);

        //設置監聽
        refresh_sfl.setOnRefreshListener(this);
        //設置下拉進度調的背景顏色默認為白色
        refresh_sfl.setProgressBackgroundColorSchemeResource(android.R.color.white);
        //設置下拉進度條更新時主題顏色
        refresh_sfl.setColorSchemeResources(R.color.colorPrimary,R.color.colorAccent, R.color.colorPrimaryDark);
        refresh_sfl.setOnLoadListener(this);
    }

    private void initData()
    {
        mList = new ArrayList<>();
        for (int i = 0; i < 30; i++)
        {
            mList.add("LHR" + i + "號");
            mCount++;
        }
    }

    //頂部下拉時會調用這個方法，在裡面實現請求數據的邏輯，設定下拉進度條消失等等
    @Override
    public void onRefresh()
    {
        //開始刷新，設置當前為刷新狀態
        refresh_sfl.setRefreshing(true);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                mList.add(0,"LHR刷新出来的");
                mAdapter.notifyDataSetChanged();
                Toast.makeText(SwipeRefreshActivity.this,"刷新成功",Toast.LENGTH_SHORT).show();
                //設置刷新為關閉
                refresh_sfl.setRefreshing(false);
            }
        },2000);
    }

    public void onLoad()
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                // 添加數據
                for (int i = 0; i < 5; i++)
                {
                    mList.add("上拉加載更多數據"+i);
                    // 这里要放在里面刷新，放在外面会导致刷新的进度条卡住
                    mAdapter.notifyDataSetChanged();
                }

                Toast.makeText(SwipeRefreshActivity.this, "加載 " + 5 + "條數據", Toast.LENGTH_SHORT).show();
                // 加载完数据设置为不加载状态，将加载进度收起来
                refresh_sfl.setLoading(false);
            }
        }, 3000);
    }

    /**
     * ListView 適配器
     */
    private class StringAdapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return mList.size();
        }

        @Override
        public Object getItem(int position)
        {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (convertView==null)
            {
                convertView = View.inflate(SwipeRefreshActivity.this,android.R.layout.simple_list_item_1,null);
            }
            TextView tv = (TextView)convertView;
            tv.setGravity(Gravity.CENTER);
            tv.setPadding(0,20,0,20);
            tv.setText(mList.get(position));
            return convertView;
        }
    }
}
