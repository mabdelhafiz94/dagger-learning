package com.dlctt.daggerlearning.profile;

import android.os.Bundle;
import android.widget.TextView;

import com.dlctt.daggerlearning.R;

import dagger.android.support.DaggerAppCompatActivity;

public class ProfileActivity extends DaggerAppCompatActivity
{
    private TextView userInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
    }

    private void initView()
    {
        userInfoText = findViewById(R.id.user_info_text);
    }
}
