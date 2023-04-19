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
import com.example.viikko12.adapters.listAdapterImportant;

import java.util.ArrayList;

public class fragmentFrontPage extends Fragment {

    private RecyclerView rcImportant;

    public fragmentFrontPage() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        rcImportant.setAdapter(new listAdapterImportant(Storage.getInstance().getShoppingsImportant(), getContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_front_page, container, false);

        rcImportant = view.findViewById(R.id.rcViewImportant);
        rcImportant.setLayoutManager(new LinearLayoutManager(getContext()));
        rcImportant.setAdapter(new listAdapterImportant(Storage.getInstance().getShoppingsImportant(), getContext()));


        return view;
    }
}