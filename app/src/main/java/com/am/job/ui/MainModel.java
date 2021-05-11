package com.am.job.ui;

import com.am.mvp.core.MVPModel;

class MainModel extends MVPModel<MainPresenter> implements MainDataAdapter,
        MainJob.Callback {

    private String mText;

    @Override
    public void load() {
        MainJob.load(this);
    }

    @Override
    public String getText() {
        return mText;
    }

    @Override
    public void onLoaded(String data) {
        mText = data;
        final MainPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.onDataLoaded();
        }
    }
}
