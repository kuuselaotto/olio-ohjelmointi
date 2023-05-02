package com.example.lutmonit.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.lutmonit.R;
import com.example.lutmonit.classes.Storage;
import com.example.lutmonit.databinding.ActivityMoveLutemonsBinding;
import com.example.lutmonit.fragments.battlefieldFragment;
import com.example.lutmonit.fragments.homeFragment;
import com.example.lutmonit.fragments.trainingFragment;

public class MoveLutemons extends AppCompatActivity {

    ActivityMoveLutemonsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoveLutemonsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new homeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.home:
                    replaceFragment(new homeFragment());
                    break;
                case R.id.training:
                    replaceFragment(new trainingFragment());
                    break;
                case R.id.battlefield:
                    replaceFragment(new battlefieldFragment());
                    break;

            }

            return true;
        });
    }

    @Override
    public void onDestroy() {
        Storage.getInstance().saveLutemons(this);
        super.onDestroy();
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }

}