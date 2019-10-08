package com.hfad.materialdesign;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior
{
    /**
     * 因為是在 xml 中使用 app:layout_behavior 定義靜態行為，
     * 所以必須實現一個構造函數使布局的效果能夠正常執行
     * 否則  Could not inflate Behavior subclass error messages.
     * @param context
     * @param attrs
     */
    public ScrollAwareFABBehavior(Context context, AttributeSet attrs)
    {
        super();
    }

    /**
     * 處理垂直方向上的滾動
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes)
    {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    /**
     * 檢測 Y 的位置，並決定按鈕動畫是否進入或退出
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed)
    {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE)
        {
            // User scrolled down and the FAB is currently visible -> hide the FAB
            child.hide();
        }
        else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE)
        {
            child.show();
        }
    }
}
