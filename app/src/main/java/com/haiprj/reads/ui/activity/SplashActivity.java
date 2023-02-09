package com.haiprj.reads.ui.activity;

import android.annotation.SuppressLint;
import android.os.Handler;

import com.haiprj.base.view.BaseActivity;
import com.haiprj.reads.R;
import com.haiprj.reads.databinding.ActivitySplashBinding;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity<ActivitySplashBinding> {
    @Override
    protected void initView() {
        new Handler().postDelayed(() -> MainActivity.start(SplashActivity.this), 5000);
    }

    @Override
    protected void addEvent() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
