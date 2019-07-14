package com.mvvmwithrecylerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mvvmwithrecylerview.R;
import com.mvvmwithrecylerview.model.UserDataModel;

import java.util.ArrayList;

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.CustomView> {
    ArrayList<UserDataModel> userDataModelsArray;

    public SimpleRecyclerAdapter(ArrayList<UserDataModel> userDataModelsArray) {
        this.userDataModelsArray = userDataModelsArray;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_adapter_layout, viewGroup, false);
        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView customView, int i) {
        UserDataModel userDataModel = userDataModelsArray.get(i);

        customView.textDes.setText(userDataModel.getDesc());
        customView.textName.setText(userDataModel.getName());


    }

    @Override
    public int getItemCount() {
        return userDataModelsArray.size();
    }

    public class CustomView extends RecyclerView.ViewHolder {

        TextView textName, textDes;

        public CustomView(@NonNull View itemView) {
            super(itemView);

            textName = (TextView) itemView.findViewById(R.id.txt_name);
            textDes = (TextView) itemView.findViewById(R.id.txt_desc);

        }
    }
}
