package com.dlctt.daggerlearning.login;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.pojo.User;
import com.dlctt.daggerlearning.model.remote.LoginRepository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

@ActivityScoped
public class LoginPresenter implements LoginContract.Presenter
{
    private LoginRepository loginRepository;
    private LoginContract.View view;

    @Inject
    LoginPresenter(LoginContract.View view, LoginRepository loginRepository)
    {
        this.view = view;
        this.loginRepository = loginRepository;
    }

    @Override
    public void login(final int userId)
    {
        view.showLoadingIndicator();
        loginRepository.login().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<List<User>>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(List<User> users)
                    {
                        for (User user : users)
                        {
                            if (user.getId() == userId)
                            {
                                view.hideLoadingIndicator();
                                view.onLoginSuccess(userId);
                                return;
                            }
                        }

                        view.hideLoadingIndicator();
                        view.onLoginFail();
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        view.hideLoadingIndicator();
                        view.onInternetError();
                    }

                    @Override
                    public void onComplete()
                    {

                    }
                });
    }

    @Override
    public void loadUsers()
    {
        view.showLoadingIndicator();
        loginRepository.login().
                retry(new Predicate<Throwable>()
                {
                    @Override
                    public boolean test(Throwable throwable)
                    {
                        return throwable instanceof UnknownHostException;
                    }
                }).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<List<User>>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {
                    }

                    @Override
                    public void onNext(List<User> users)
                    {
                        view.hideLoadingIndicator();
                        view.onUsersLoaded(new ArrayList<>(users));
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        view.hideLoadingIndicator();
                        view.onInternetError();
                    }

                    @Override
                    public void onComplete()
                    {

                    }
                });
    }

    @Override
    public void unsubscribe()
    {

    }
}
