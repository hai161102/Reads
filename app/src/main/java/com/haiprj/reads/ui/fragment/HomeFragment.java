package com.haiprj.reads.ui.fragment;

import android.view.View;

import com.haiprj.base.mvp.view.ViewResult;
import com.haiprj.reads.R;
import com.haiprj.reads.databinding.FragmentHomeBinding;
import com.haiprj.reads.models.ItemFiles;
import com.haiprj.reads.mvp.presenter.AppDataPresenter;
import com.haiprj.reads.ui.adapter.ItemFileAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> implements ViewResult {

    private boolean isEmpty = false;
    private final String TAG = "HomeFragment";
    private final List<ItemFiles> list = new ArrayList<>();
    private final AppDataPresenter dataPresenter;

    private ItemFileAdapter itemFileAdapter;

    public HomeFragment() {
        dataPresenter = new AppDataPresenter(this);
    }

    @Override
    protected void initView(View view) {
        itemFileAdapter = new ItemFileAdapter(requireContext(), list);
        dataPresenter.loadFile(TAG);
        if (isEmpty) {
            showViewEmpty();
        }
    }

    private void showViewEmpty() {
        binding.emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void addEvent(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onViewAvailable(String key, Object... objects) {
        if (Objects.equals(key, "loadFile")) {
            list.clear();
            list.addAll((Collection<? extends ItemFiles>) objects[0]);
            onFileAvailable();
        }
    }

    private void onFileAvailable() {
        isEmpty = list.isEmpty();
        if (isEmpty) {
            showViewEmpty();
        }
        else hideViewEmpty();
        itemFileAdapter.update(list);
    }

    private void hideViewEmpty() {
        binding.emptyView.setVisibility(View.GONE);
    }

    @Override
    public void onViewNotAvailable(String mess) {

    }
}
