package com.haiprj.reads.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.haiprj.base.view.BaseActivity;
import com.haiprj.reads.OnActionCallback;
import com.haiprj.reads.R;
import com.haiprj.reads.databinding.ActivitySettingsBinding;

public class SettingsActivity extends BaseActivity<ActivitySettingsBinding> {

    private static OnActionCallback callback;

    public static void start(Context context, OnActionCallback onActionCallback) {
        callback = onActionCallback;
        Intent starter = new Intent(context, SettingsActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void addEvent() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        callback = null;
    }
}
