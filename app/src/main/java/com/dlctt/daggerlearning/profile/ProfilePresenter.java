package com.dlctt.daggerlearning.profile;

import com.dlctt.daggerlearning.di.ActivityScoped;
import com.dlctt.daggerlearning.model.pojo.User;
import com.dlctt.daggerlearning.model.remote.UsersRepository;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@ActivityScoped
public class ProfilePresenter implements ProfileContract.Presenter
{
    private UsersRepository usersRepository;
    private ProfileContract.View view;

    @Inject
    ProfilePresenter(ProfileContract.View view, UsersRepository usersRepository)
    {
        this.view = view;
        this.usersRepository = usersRepository;
    }

    @Override
    public void loadUserProfile(Integer userId)
    {
        view.showLoadingIndicator();
        usersRepository.getUserProfile(userId).
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
                        view.onProfileLoaded(user);
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
