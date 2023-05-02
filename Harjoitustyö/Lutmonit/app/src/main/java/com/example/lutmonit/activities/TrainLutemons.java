package com.example.lutmonit.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lutmonit.R;
import com.example.lutmonit.adapters.lutemonTrainAdapter;
import com.example.lutmonit.classes.Storage;

public class TrainLutemons extends AppCompatActivity {

    private RecyclerView rcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_lutemons);

        rcView = findViewById(R.id.rcViewTrain);

        rcView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcView.setAdapter(new lutemonTrainAdapter(getApplicationContext(), Storage.getInstance().getLutemonsTraining()));

    }
    @Override
    public void onDestroy() {
        Storage.getInstance().saveLutemons(this);
        super.onDestroy();
    }
}