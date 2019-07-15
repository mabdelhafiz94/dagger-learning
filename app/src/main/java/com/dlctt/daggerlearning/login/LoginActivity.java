package com.dlctt.daggerlearning.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import java.util.Random;

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
    boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usersAdapter = new UsersAdapter(new UsersDiffCallback(), this);
        initView();
        prepViews();
        presenter.loadUsers();

        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                presenter.loadUsers();
            }
        };

        new Handler().postDelayed(runnable, 5000);
        new Handler().postDelayed(runnable, 10000);
        new Handler().postDelayed(runnable, 15000);
        new Handler().postDelayed(runnable, 20000);
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
        if (!first)
        {
            int random = new Random(System.currentTimeMillis()).nextInt();
            User user = new User();
            User user1 = new User();
            User user2 = new User();
            user.setId(random);
            user1.setId(random + 1);
            user2.setId(random + 2);

            users.clear();
            users.add(user);
            users.add(user1);
            users.add(user2);
        }

        usersAdapter.addMoreUsers(users);
        first = false;
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
