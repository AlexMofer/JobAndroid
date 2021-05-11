package com.am.job.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.am.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MainView {

    private final MainPresenter mPresenter = new MainPresenter().setViewHolder(getViewHolder());
    private TextView mVText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVText = findViewById(R.id.text);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mVText.setText("正在加载数据...");
        mPresenter.load();
    }

    // View
    @Override
    public void onDataLoaded() {
        mVText.setText(mPresenter.getText());
    }
}