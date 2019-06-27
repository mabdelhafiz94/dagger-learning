package com.dlctt.daggerlearning.login;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.pojo.User;
import com.dlctt.daggerlearning.model.remote.LoginRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@ActivityScoped
public class LoginPresenter implements LoginContract.Presenter
{
    private LoginRepository loginRepository;
    private LoginContract.View view;

    @Inject
    public LoginPresenter(LoginContract.View view, LoginRepository loginRepository)
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
                                view.onLoginSuccess();
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
    public void unsubscribe()
    {

    }
}
