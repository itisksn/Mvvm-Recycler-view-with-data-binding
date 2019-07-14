package com.mvvmwithrecylerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mvvmwithrecylerview.databinding.UserBinding;
import com.mvvmwithrecylerview.viewModel.UserViewDataModel;

import java.util.ArrayList;

public class MvvmRecyclerAdapterWithBinding extends RecyclerView.Adapter<MvvmRecyclerAdapterWithBinding.CustomView> {

    private ArrayList<UserViewDataModel> userDataViewModelsArray;
    private LayoutInflater layoutInflater;

    public MvvmRecyclerAdapterWithBinding(ArrayList<UserViewDataModel> userDataViewModelsArray) {
        this.userDataViewModelsArray = userDataViewModelsArray;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        UserBinding userBinding = UserBinding.inflate(layoutInflater, viewGroup, false);


        // View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mvvm_adapter_layout, viewGroup, false);
        // return new CustomView(view);
        return new CustomView(userBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView customView, int i) {
        UserViewDataModel userViewDataModel = userDataViewModelsArray.get(i);

/*
        customView.textDes.setText(userDataModel.getDesc());
        customView.textName.setText(userDataModel.getName());
*/

        customView.bindData(userViewDataModel);
    }

    @Override
    public int getItemCount() {
        return userDataViewModelsArray.size();
    }

    public class CustomView extends RecyclerView.ViewHolder {

        //        TextView textName, textDes;
        private UserBinding userBinding;

        public CustomView(UserBinding userBinding) {//@NonNull View itemView
            super(userBinding.getRoot());
            this.userBinding = userBinding;
           /* textName = (TextView) itemView.findViewById(R.id.txt_name);
            textDes = (TextView) itemView.findViewById(R.id.txt_desc);
*/
        }

        public void bindData(UserViewDataModel userViewDataModel) {
            this.userBinding.setUserViewModel(userViewDataModel);

        }

        public UserBinding getUserBinding() {
            return userBinding;
        }

    }
}
