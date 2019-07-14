package com.mvvmwithrecylerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.mvvmwithrecylerview.adapter.SimpleRecyclerAdapter;
import com.mvvmwithrecylerview.model.UserDataModel;

import java.util.ArrayList;

public class SimpleRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SimpleRecyclerAdapter simpleRecyclerAdapter;
    ArrayList<UserDataModel> userDataModelsArray = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_recyler_activity);
        setData();
    }

    void setData() {
        UserDataModel userDataModel = new UserDataModel();
        userDataModel.setDesc("itiskrishan@gmail.com");
        userDataModel.setName("Krishan");
        userDataModelsArray.add(userDataModel);
        UserDataModel userDataModel1 = new UserDataModel();
        userDataModel1.setDesc("itisksn@gmail.com");
        userDataModel1.setName("Mohan verma");
        userDataModelsArray.add(userDataModel1);
        UserDataModel userDataModel2 = new UserDataModel();
        userDataModel2.setDesc("Ahaan");
        userDataModel2.setName("ksn verma");
        userDataModelsArray.add(userDataModel2);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        simpleRecyclerAdapter = new SimpleRecyclerAdapter(userDataModelsArray);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        simpleRecyclerAdapter.notifyDataSetChanged();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SimpleRecyclerViewActivity.this, RecyclerWithMvvmActivity.class));
            }
        });

    }
}
