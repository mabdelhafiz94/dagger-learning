package com.dlctt.daggerlearning.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dlctt.daggerlearning.R;
import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.pojo.User;
import com.dlctt.daggerlearning.utils.Constants;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

@ActivityScoped
public class ProfileActivity extends DaggerAppCompatActivity implements ProfileContract.View
{
    private TextView userInfoText;
    private ProgressBar loadingIndicator;

    @Inject
    ProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
        int userId = getIntent().getIntExtra(Constants.USER_ID_KEY, 0);

        profilePresenter.loadUserProfile(userId);
    }

    private void initView()
    {
        userInfoText = findViewById(R.id.user_info_text);
        loadingIndicator = findViewById(R.id.loading_indicator);
    }

    @Override
    public void onProfileLoaded(User user)
    {
        userInfoText.setText(user.toString());
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

    }
}
