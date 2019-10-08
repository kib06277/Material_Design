package com.hfad.materialdesign.activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.hfad.materialdesign.R;

public class SnackBarActivity extends AppCompatActivity
{
    private FloatingActionButton mFloatingActionButton;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

//        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.layoutRoot);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

//        mFloatingActionButton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Snackbar mSnackbar = Snackbar.make(mCoordinatorLayout, "Hello Snackbar LHR", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener()
//                {
//                    @Override
//                    public void onClick(View v)
//                    {
//                        Log.d("Snckbar", "OK");
//                    }
//                });
//                setSnackbarColor(mSnackbar, Color.BLACK,Color.BLUE);
//                SnackbarAddView(mSnackbar,R.layout.snackbaricon,0);
//                mSnackbar.show();
//            }
//        });
    }


    // 更改 Snackbar 字體顏色，背景顏色
    public static void setSnackbarColor(Snackbar Snackbar, int TextColorColor, int backgroundColor)
    {
        View view = Snackbar.getView();
        if (view != null)
        {
            view.setBackgroundColor(backgroundColor);
            // 獲取 Snackbar 的 message 控件，修改字體顏色
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(TextColorColor);
        }

    }
    // 為 Snackbar 添加圖標
    public static void SnackbarAddView(Snackbar snackbar,int layoutId,int index)
    {
        View snackbarview = snackbar.getView();//獲取 Snackbar 的 View (其實是 SnackbarLayout)
        Snackbar.SnackbarLayout snackbarLayout=(Snackbar.SnackbarLayout)snackbarview;//將獲取的 View 轉換成 SnackbarLayout
        View add_view = LayoutInflater.from(snackbarview.getContext()).inflate(layoutId,null);//加載布局文件新建 View
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);//設置新布局參數
        p.gravity = Gravity.CENTER_VERTICAL;//設置新建布局在 Snackbar 內垂直居中顯示
        snackbarLayout.addView(add_view,index,p);//將新建布局添加進 snackbarLayout 相應位置
    }
}
