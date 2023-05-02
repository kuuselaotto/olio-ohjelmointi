package com.example.lutmonit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lutmonit.R;
import com.example.lutmonit.classes.Storage;

public class MainActivity extends AppCompatActivity {

    private Storage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = Storage.getInstance();
        storage.loadLutemons(this);
    }

    @Override
    public void onDestroy() {
        storage.saveLutemons(this);
        super.onDestroy();
    }
    public void switchToAddLutemons(View view) {
        Intent intent = new Intent(this, AddLutemons.class);
        startActivity(intent);
    }

    public void switchToMoveLutemons(View view) {
        Intent intent = new Intent(this, MoveLutemons.class);
        startActivity(intent);
    }

    public void switchToBattleField(View view) {
        Intent intent = new Intent(this, LutemonFight.class);
        startActivity(intent);
    }
    public void switchToTrain(View view) {
        Intent intent = new Intent(this, TrainLutemons.class);
        startActivity(intent);
    }
}