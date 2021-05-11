package com.am.job.ui;

import com.am.mvp.core.MVPPresenter;

class MainPresenter extends MVPPresenter<MainView, MainModel> implements MainView, MainDataAdapter {

    MainPresenter() {
        setModel(new MainModel());
    }

    // View
    @Override
    public void onDataLoaded() {
        final MainView view = getView();
        if (view == null) {
            return;
        }
        view.onDataLoaded();
    }

    // DataAdapter
    @Override
    public void load() {
        getModel().load();
    }

    @Override
    public String getText() {
        return getModel().getText();
    }
}
