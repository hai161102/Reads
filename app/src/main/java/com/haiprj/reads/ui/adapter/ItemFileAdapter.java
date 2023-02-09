package com.haiprj.reads.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.haiprj.base.view.BaseAdapter;
import com.haiprj.base.view.BaseViewHolder;
import com.haiprj.reads.R;
import com.haiprj.reads.databinding.ItemFilesBinding;
import com.haiprj.reads.models.ItemFiles;

import java.util.List;

public class ItemFileAdapter extends BaseAdapter<ItemFilesBinding, ItemFiles> {

    public ItemFileAdapter(Context context, List<ItemFiles> list) {
        super(context, list);
    }

    public ItemFileAdapter() {
    }

    @Override
    protected BaseViewHolder<ItemFilesBinding> getViewHolder() {
        ItemFilesBinding itemFilesBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_files, parent, false);
        return new ViewHolder(itemFilesBinding);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class ViewHolder extends BaseViewHolder<ItemFilesBinding>{

        public ViewHolder(@NonNull ItemFilesBinding binding) {
            super(binding);
        }

        @Override
        public void load(Object object) {
            ItemFiles itemFiles = (ItemFiles) object;

        }
    }
}
