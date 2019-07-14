package com.mvvmwithrecylerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mvvmwithrecylerview.adapter.MvvmRecyclerAdapterWithBinding;
import com.mvvmwithrecylerview.model.UserDataModel;
import com.mvvmwithrecylerview.viewModel.UserViewDataModel;

import java.util.ArrayList;

public class RecyclerWithMvvmActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MvvmRecyclerAdapterWithBinding mvvmRecyclerAdapterWithBinding;
    ArrayList<UserViewDataModel> userViewDataModels = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvvm_recyler_activity);
        setData();


    }

    void setData() {
        UserDataModel userData = new UserDataModel();
        userData.setDesc("itiskrishan@gmail.com");
        userData.setName("Krishan Mohan Verma");
        UserViewDataModel userDataModel = new UserViewDataModel(userData);
        userViewDataModels.add(userDataModel);

        UserDataModel userData1 = new UserDataModel();
        userData1.setDesc("itisksn@gmail.com");
        userData1.setName("ksn verma");
        UserViewDataModel userDataModel1 = new UserViewDataModel(userData1);
        userViewDataModels.add(userDataModel1);

        UserDataModel userData2 = new UserDataModel();
        userData2.setDesc("Ahaan");
        userData2.setName("Paras verma");
        UserViewDataModel userDataModel2 = new UserViewDataModel(userData2);
        userViewDataModels.add(userDataModel2);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mvvmRecyclerAdapterWithBinding = new MvvmRecyclerAdapterWithBinding(userViewDataModels);
        recyclerView.setAdapter(mvvmRecyclerAdapterWithBinding);
        mvvmRecyclerAdapterWithBinding.notifyDataSetChanged();

    }
}
