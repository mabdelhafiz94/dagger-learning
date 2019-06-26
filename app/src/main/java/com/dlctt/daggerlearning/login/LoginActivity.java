package com.dlctt.daggerlearning.login;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.dlctt.daggerlearning.R;
import com.dlctt.daggerlearning.model.remote.LoginApi;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends DaggerAppCompatActivity
{
    private static final String TAG = "LoginActivity";

    private ImageView logoImg;
    private EditText idInput;
    private Button loginBtn;

    @Inject
    public Picasso picasso;

    @Inject
    public LoginApi loginApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();


        picasso.load(R.drawable.ic_launcher_background).
                placeholder(R.drawable.ic_launcher_background).
                error(R.drawable.ic_launcher_background).into(logoImg);

        Log.d(TAG, "onCreate: " + (loginApi != null));

    }

    private void initView()
    {
        logoImg = findViewById(R.id.logo_img);
        idInput = findViewById(R.id.id_input);
        loginBtn = findViewById(R.id.login_btn);
    }
}
