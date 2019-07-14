package com.mvvmwithrecylerview.viewModel;

import com.mvvmwithrecylerview.model.UserDataModel;

public class UserViewDataModel {

    public UserViewDataModel(UserDataModel userDataModel) {
        this.name = userDataModel.name;
        this.desc = userDataModel.desc;
    }

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String desc;


}
