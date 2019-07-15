package com.dlctt.daggerlearning.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dlctt.daggerlearning.R;
import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.home.HomeActivity;
import com.dlctt.daggerlearning.model.pojo.User;
import com.dlctt.daggerlearning.utils.Constants;
import com.dlctt.daggerlearning.utils.ListItemCallback;
import com.dlctt.daggerlearning.utils.UsersDiffCallback;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

@ActivityScoped
public class LoginActivity extends DaggerAppCompatActivity implements LoginContract.View, View.OnClickListener, ListItemCallback<User>
{
    private static final String TAG = "LoginActivity";

    @Inject
    LoginContract.Presenter presenter;

    private ProgressBar loadingIndicator;
    private RecyclerView usersList;
    private UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usersAdapter = new UsersAdapter(new UsersDiffCallback(), this);
        initView();
        prepViews();
        presenter.loadUsers();
    }

    private void initView()
    {
        loadingIndicator = findViewById(R.id.loading_indicator);
        usersList = findViewById(R.id.users_list);
    }

    private void prepViews()
    {
        usersList.setItemAnimator(new DefaultItemAnimator());
        usersList.setLayoutManager(new LinearLayoutManager(this));
        usersList.setAdapter(usersAdapter);
    }

    @Override
    public void onClick(View v)
    {

    }

    @Override
    public void onLoginSuccess(int userId)
    {
        Toast.makeText(this, "onLoginSuccess", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(Constants.USER_ID_KEY, userId);
        startActivity(intent);
    }

    @Override
    public void onUsersLoaded(ArrayList<User> users)
    {
        usersAdapter.submitList(users);
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

    @Override
    public void onItemClicked(User user)
    {
        Toast.makeText(this, user.getName(), Toast.LENGTH_SHORT).show();
    }
}
