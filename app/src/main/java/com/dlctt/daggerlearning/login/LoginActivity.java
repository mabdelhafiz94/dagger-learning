package com.dlctt.daggerlearning.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dlctt.daggerlearning.R;
import com.dlctt.daggerlearning.di.ActivityScoped;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

@ActivityScoped
public class LoginActivity extends DaggerAppCompatActivity implements LoginContract.View, View.OnClickListener
{
    private static final String TAG = "LoginActivity";

    private EditText idInput;
    private Button loginBtn;

    @Inject
    LoginPresenter presenter;

    private ProgressBar loadingIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        prepViews();
    }

    private void initView()
    {
        idInput = findViewById(R.id.id_input);
        loginBtn = findViewById(R.id.login_btn);
        loadingIndicator = findViewById(R.id.loading_indicator);
    }

    private void prepViews()
    {
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        presenter.login(Integer.valueOf(idInput.getText().toString()));
    }

    @Override
    public void onLoginSuccess()
    {
        Toast.makeText(this, "onLoginSuccess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail()
    {
        Toast.makeText(this, "onLoginFail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingIndicator()
    {
        loadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator()
    {
        loadingIndicator.setVisibility(View.GONE);
    }

    @Override
    public void onInternetError()
    {
        Toast.makeText(this, "onInternetError", Toast.LENGTH_SHORT).show();
    }
}
