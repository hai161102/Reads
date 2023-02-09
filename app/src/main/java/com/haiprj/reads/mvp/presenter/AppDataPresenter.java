package com.haiprj.reads.mvp.presenter;

import com.haiprj.base.mvp.presenter.DataPresenter;
import com.haiprj.base.mvp.view.ViewResult;
import com.haiprj.reads.mvp.model.AppDataModel;

public class AppDataPresenter extends DataPresenter {
    public AppDataPresenter(ViewResult viewResult) {
        super(viewResult);
        dataModel = new AppDataModel(this);
    }

    public void loadFile(String tag) {
        ((AppDataModel)dataModel).loadFile(tag);
    }
}
