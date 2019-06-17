package com.dlctt.daggerlearning.login;

import android.os.Bundle;
import android.util.Log;

import com.dlctt.daggerlearning.R;
import com.dlctt.daggerlearning.models.User;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends DaggerAppCompatActivity
{
    @Inject
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d("onCreate", "" + user.getId());
    }
}
