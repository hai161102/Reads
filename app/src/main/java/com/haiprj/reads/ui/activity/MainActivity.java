package com.haiprj.reads.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.haiprj.base.view.BaseActivity;
import com.haiprj.reads.R;
import com.haiprj.reads.databinding.ActivityMainBinding;
import com.haiprj.reads.ui.adapter.ViewPagerAdapter;
import com.haiprj.reads.ui.fragment.HomeFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private HomeFragment homeFragment;
    private ViewPagerAdapter viewPagerAdapter;
    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void initView() {
        setupViewPager();
    }

    private void setupViewPager() {
        homeFragment = new HomeFragment();
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPagerAdapter.add(homeFragment);
        binding.viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    protected void addEvent() {
        binding.edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0){
                    binding.clearText.setVisibility(View.INVISIBLE);
                }
                else if (s.length() > 0) {
                    binding.clearText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.edtSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    binding.edtSearch.setCursorVisible(true);
                }
            }
        });

        binding.clearText.setOnClickListener(v -> {
            emptyTextSearch();
        });

        binding.settings.setOnClickListener(v -> {
            SettingsActivity.start(this, (key, objects) -> {

            });
        });
    }

    private void emptyTextSearch() {
        binding.edtSearch.setText("");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}