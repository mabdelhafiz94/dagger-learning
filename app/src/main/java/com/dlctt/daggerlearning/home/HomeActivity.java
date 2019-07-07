package com.dlctt.daggerlearning.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dlctt.daggerlearning.R;
import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.pojo.User;
import com.dlctt.daggerlearning.utils.Constants;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

@ActivityScoped
public class HomeActivity extends DaggerAppCompatActivity implements HomeContract.View
{
    private TextView userInfoText;
    private ProgressBar loadingIndicator;

    @Inject
    HomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();

        int userId = getIntent().getIntExtra(Constants.USER_ID_KEY, 0);

        presenter.loadUserInfo(userId);
    }

    private void initView()
    {
        userInfoText = findViewById(R.id.user_info_text);
        loadingIndicator = findViewById(R.id.loading_indicator);
    }

    @Override
    public void onUserInfoLoaded(User user)
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
        Toast.makeText(this, "onInternetError", Toast.LENGTH_SHORT).show();
    }
}
