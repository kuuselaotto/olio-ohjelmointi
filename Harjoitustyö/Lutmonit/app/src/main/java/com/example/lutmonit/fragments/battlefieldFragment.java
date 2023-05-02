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
import com.example.lutmonit.adapters.lutemonBattleListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class battlefieldFragment extends Fragment {

    private Storage storage;
    private RecyclerView recyclerView;
    private lutemonBattleListAdapter adapter;
    private ArrayList<Lutemon> lutemonsBattle = new ArrayList<>();

    public battlefieldFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {

            lutemonsBattle = storage.getLutemonsBattle();

            recyclerView = view.findViewById(R.id.rcView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new lutemonBattleListAdapter(getContext(), lutemonsBattle);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        lutemonsBattle = storage.getLutemonsBattle();
        adapter = new lutemonBattleListAdapter(getContext(), lutemonsBattle);
        recyclerView.setAdapter(adapter);
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
        return inflater.inflate(R.layout.fragment_battlefield, container, false);
    }
}