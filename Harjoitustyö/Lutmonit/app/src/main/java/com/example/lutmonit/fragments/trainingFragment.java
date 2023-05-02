package com.example.lutmonit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lutmonit.classes.Lutemon;
import com.example.lutmonit.R;
import com.example.lutmonit.classes.Storage;
import com.example.lutmonit.adapters.lutemonTrainingAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class trainingFragment extends Fragment {
    private Storage storage;
    private RecyclerView recyclerView;
    private lutemonTrainingAdapter adapter;
    private ArrayList<Lutemon> lutemonsTraining = new ArrayList<>();

    public trainingFragment() {
    }


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {

            lutemonsTraining = storage.getLutemonsTraining();

            recyclerView = view.findViewById(R.id.rcTrainingView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new lutemonTrainingAdapter(getContext(), lutemonsTraining);
            recyclerView.setAdapter(adapter);

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        storage = Storage.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_training, container, false);
    }
}