package com.hfad.materialdesign.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.hfad.materialdesign.R;

/**
 * 自訂義 View 繼承 SwipeRefreshLayout，添加上拉加載更多的布局屬性
 */
public class SwipeRefreshView extends SwipeRefreshLayout
{
    private final int mScaledTouchSlop;
    private final View mFooterView;
    private ListView mListView;
    private OnLoadListener mOnLoadListener;

    /**
     * 正在加載狀況
     */
    private boolean isLoading;

    public SwipeRefreshView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        // 填充底部加載布局
        mFooterView = View.inflate(context, R.layout.view_footer, null);

        // 表示控件移動的最小距離，手移動的距離大於這個距離才能拖動控件
        mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        System.out.println("====" + mScaledTouchSlop);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        super.onLayout(changed, left, top, right, bottom);

        // 獲取 ListView ，設置 ListView 的布局位置
        if (mListView == null)
        {
            //判斷容器有多少東西
            if (getChildCount() > 0)
            {
                //判斷第一個物件是不是 ListView
                if (getChildAt(0) instanceof ListView)
                {
                    //創建 ListView 對象
                    mListView = (ListView) getChildAt(0);

                    // 設置 ListView 的滑動監聽
                    setListViewOnScroll();
                }
            }
        }
    }

    /**
     * 在分發事件的時候處理子控件的觸發事件
     * @param ev
     * @return
     */
    private float mDownY, mUpY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        switch (ev.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                //移動的起點
                mDownY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //移動過程中判斷能下拉加載更多
                if (canLoadMore())
                {
                    //加載數據
                    loadData();
                }
                break;
            case MotionEvent.ACTION_UP:
                // 移動終點
                mUpY = getY();
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     *判斷是否滿足更多加載條件
     * @return
     */
    private boolean canLoadMore()
    {
        // 1.上拉狀態
        boolean condition1 = (mDownY - mUpY) >= mScaledTouchSlop;
        if (condition1)
        {
            System.out.println("上拉狀態");
        }

        // 2.當前頁面可見的 item 是最後一個項目
        boolean condition2 = false;
        if (mListView != null && mListView.getAdapter() != null)
        {
            condition2 = mListView.getLastVisiblePosition() == (mListView.getAdapter().getCount() - 1);
        }

        if (condition2)
        {
            System.out.println("最後一個項目");
        }

        // 3. 不是正在加載狀態
        boolean condition3 = !isLoading;
        if (condition3)
        {
            System.out.println("非加載狀態");
        }
        return condition1 && condition2 && condition3;
    }

    /**
     * 處理加載數據
     */
    private void loadData()
    {
        System.out.println("加載數據...");
        if (mOnLoadListener != null)
        {
            // 設置加載狀太，讓布局顯示出來
            setLoading(true);
            mOnLoadListener.onLoad();
        }

    }

    /**
     * 設置加載狀態，是否加載傳入 boolean 值判斷
     * @param loading
     */
    public void setLoading(boolean loading)
    {
        // 修改當前狀態
        isLoading = loading;
        if (isLoading)
        {
            // 顯示布局
            mListView.addFooterView(mFooterView);

            // 自動跳轉到底部
            mListView.smoothScrollToPosition(mListView.getCount()-1);
        }
        else
        {
            // 隱藏不具
            mListView.removeFooterView(mFooterView);

            // 重製滑鼠座標
            mDownY = 0;
            mUpY = 0;
        }
    }

    /**
     *  設置 ListView 的滑動監聽
     */
    private void setListViewOnScroll()
    {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener()
        {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState)
            {
                //移動過程中判斷下拉加載更多
                if (canLoadMore())
                {
                    // 加載數據
                    loadData();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
            {

            }
        });
    }


    /**
     *  上拉加載的接口回調
     */
    public interface OnLoadListener
    {
        void onLoad();
    }

    public void setOnLoadListener(OnLoadListener listener)
    {
        this.mOnLoadListener = listener;
    }
}
