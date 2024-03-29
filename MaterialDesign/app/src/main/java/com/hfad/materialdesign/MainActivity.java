package com.hfad.materialdesign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hfad.materialdesign.activity.CardViewActivity;
import com.hfad.materialdesign.activity.FabActivity;
import com.hfad.materialdesign.activity.LinearProgressActivity;
import com.hfad.materialdesign.activity.NavigationDrawerActivity;
import com.hfad.materialdesign.activity.SearchActivity;
import com.hfad.materialdesign.activity.SnackBarActivity;
import com.hfad.materialdesign.activity.SwipeRefreshActivity;
import com.hfad.materialdesign.activity.TabsActivity;
import com.hfad.materialdesign.activity.TextInputActivity;
import com.hfad.materialdesign.activity.TranslucentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button btn_snackbar;
    private Button btn_lp;
    private Button btn_card;
    private Button btn_tab;
    private Button btn_alert;
    private Button btn_textinputlayout;
    private Button btn_fab;
    private Button btn_cdl;
    private Button btn_navigationdrawer;
    private Button btn_TranslucentActivity;
    private Button btn_SwipeRefreshLayout;
    private Button btn_SearchActivity;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_snackbar = (Button) findViewById(R.id.btn_snackbar);
        btn_lp = (Button) findViewById(R.id.btn_lp);
        btn_card = (Button) findViewById(R.id.btn_card);
        btn_tab = (Button) findViewById(R.id.btn_tab);
        btn_alert = (Button) findViewById(R.id.btn_alert);
        btn_fab = (Button) findViewById(R.id.btn_fab);
        btn_cdl = (Button) findViewById(R.id.btn_cdl);
        btn_navigationdrawer = (Button) findViewById(R.id.btn_navigationdrawer);
        btn_textinputlayout = (Button) findViewById(R.id.btn_textinputlayout);
        btn_TranslucentActivity = (Button) findViewById(R.id.btn_TranslucentActivity);
        btn_SwipeRefreshLayout = (Button) findViewById(R.id.btn_SwipeRefreshLayout);
        btn_SearchActivity = (Button) findViewById(R.id.btn_SearchActivity);

        btn_snackbar.setOnClickListener(this);
        btn_lp.setOnClickListener(this);
        btn_card.setOnClickListener(this);
        btn_tab.setOnClickListener(this);
        btn_alert.setOnClickListener(this);
        btn_textinputlayout.setOnClickListener(this);
        btn_fab.setOnClickListener(this);
        btn_cdl.setOnClickListener(this);
        btn_navigationdrawer.setOnClickListener(this);
        btn_TranslucentActivity.setOnClickListener(this);
        btn_SwipeRefreshLayout.setOnClickListener(this);
        btn_SearchActivity.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_snackbar:
                mIntent = new Intent(MainActivity.this, SnackBarActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_lp:
                mIntent = new Intent(MainActivity.this, LinearProgressActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_card:
                mIntent = new Intent(MainActivity.this, CardViewActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_tab:
                mIntent = new Intent(MainActivity.this, TabsActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_alert:
                showLocationDialog();
                break;
            case R.id.btn_textinputlayout:
                mIntent = new Intent(MainActivity.this, TextInputActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_fab:
                mIntent = new Intent(MainActivity.this, FabActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_cdl:
                mIntent = new Intent(MainActivity.this, CoordinatorLayout.class);
                startActivity(mIntent);
                break;
            case R.id.btn_navigationdrawer:
                mIntent = new Intent(MainActivity.this, NavigationDrawerActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_TranslucentActivity:
                mIntent = new Intent(MainActivity.this, TranslucentActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_SwipeRefreshLayout:
                mIntent = new Intent(MainActivity.this, SwipeRefreshActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_SearchActivity:
                mIntent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(mIntent);
                break;
        }
    }

    private void showLocationDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme);
        builder.setTitle("我是Title");
        builder.setMessage("我是主内容.....................");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Log.d("Dialog", "OK");
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Log.d("Dialog", "cancel");
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
