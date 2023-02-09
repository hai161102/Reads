package com.haiprj.reads.mvp.model;

import com.haiprj.base.mvp.model.DataModel;
import com.haiprj.base.mvp.model.DataResult;

import java.util.ArrayList;

public class AppDataModel extends DataModel {
    public AppDataModel(DataResult dataResult) {
        super(dataResult);
    }

    public void loadFile(String tag) {

        dataResult.onDataResultSuccess("loadFile", new ArrayList<>());
    }
}
