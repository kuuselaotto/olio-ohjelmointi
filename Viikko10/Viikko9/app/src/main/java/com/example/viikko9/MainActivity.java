package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Animation scaleUp, scaleDown;
    private Button buttonAdd, buttonList;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonList = findViewById(R.id.buttonList);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        context = this;

    }


    public void switchToListUsers(View view) {

        buttonList.startAnimation(scaleUp);
        buttonList.startAnimation(scaleDown);

        UserStorage.getInstance().loadUsers(context);

        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

    public void switchToAddUsers(View view) {

        buttonAdd.startAnimation(scaleUp);
        buttonAdd.startAnimation(scaleDown);

        Intent intent = new Intent(this, UserAddActivity.class);
        startActivity(intent);
    }



}