package com.am.job.ui;

import com.am.job.Job;

class MainJob extends Job<MainJob.Callback> {

    private MainJob(Callback callback, int id, Object... params) {
        super(callback, id, params);
    }

    static void load(Callback callback) {
        new MainJob(callback, 0).execute();
    }

    @Override
    protected void doInBackground(Result result) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // ignore
        }
        result.set(true, "数据已从Job中加载！");
    }

    @Override
    protected void onResult(Callback callback, Result result) {
        super.onResult(callback, result);
        callback.onLoaded(result.getString(0));
    }

    public interface Callback {

        void onLoaded(String data);
    }
}
