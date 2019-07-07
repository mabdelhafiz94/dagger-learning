package com.dlctt.daggerlearning.home;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.pojo.User;
import com.dlctt.daggerlearning.model.remote.UsersRepository;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@ActivityScoped
public class HomePresenter implements HomeContract.Presenter
{
    private HomeContract.View view;
    private UsersRepository usersRepository;

    @Inject
    public HomePresenter(HomeContract.View view, UsersRepository usersRepository)
    {
        this.view = view;
        this.usersRepository = usersRepository;
    }

    @Override
    public void loadUserInfo(Integer userId)
    {
        view.showLoadingIndicator();

        usersRepository.getUserById(userId).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<User>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(User user)
                    {
                        view.hideLoadingIndicator();
                        view.onUserInfoLoaded(user);
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
