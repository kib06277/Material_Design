package com.hfad.materialdesign.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.hfad.materialdesign.R;

public class TextInputActivity extends AppCompatActivity
{
    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordnameWrapper;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinput);
        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        passwordnameWrapper = (TextInputLayout) findViewById(R.id.passwordnameWrapper);
        login = (Button) findViewById(R.id.login);

        //EditText 默認的字符與點擊後上移的字符，在 xml 設置也可以得到相同效果
        usernameWrapper.setHint("Username");
        passwordnameWrapper.setHint("Password");

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                hideKeyboard();
                String username = usernameWrapper.getEditText().getText().toString();
                String password = passwordnameWrapper.getEditText().getText().toString();
                if (!username.equals("lhr"))
                {
                    usernameWrapper.setError("你輸入的ID錯誤");
                }
                else if (!password.equals("123456"))
                {
                    passwordnameWrapper.setError("你輸入的密碼錯誤");
                }
                else
                {
                    usernameWrapper.setErrorEnabled(false);
                    passwordnameWrapper.setErrorEnabled(false);
                    finish();
                }
            }
        });
    }

    private void hideKeyboard()
    {
        View view = getCurrentFocus();
        if (view == null)
        {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
