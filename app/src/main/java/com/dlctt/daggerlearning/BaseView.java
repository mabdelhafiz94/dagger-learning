package com.dlctt.daggerlearning;

public interface BaseView
{
    void showLoadingIndicator();

    void hideLoadingIndicator();

    void onInternetError();
}
