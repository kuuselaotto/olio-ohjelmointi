package com.example.viikko12.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viikko12.R;
import com.example.viikko12.Shopping;
import com.example.viikko12.Storage;
import com.example.viikko12.adapters.ShoppingListAdapter;
import com.example.viikko12.adapters.listAdapterImportant;

import java.util.ArrayList;


public class fragmentList extends Fragment {

    private RecyclerView rc;

    public fragmentList() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        rc.setAdapter(new ShoppingListAdapter(Storage.getInstance().getShoppings(), getContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);


        rc = view.findViewById(R.id.rcView);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rc.setAdapter(new ShoppingListAdapter(Storage.getInstance().getShoppings(), getContext()));

        return view;
    }
}