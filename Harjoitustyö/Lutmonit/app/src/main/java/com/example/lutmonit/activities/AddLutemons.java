package com.example.lutmonit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lutmonit.classes.Lutemon;
import com.example.lutmonit.R;
import com.example.lutmonit.classes.Storage;

public class AddLutemons extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;
    private Storage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemons);

        radioGroup = findViewById(R.id.radioGroupColours);
        textView = findViewById(R.id.txtLutemonName);
        storage = Storage.getInstance();

    }

    public void addLutemon(View view) {

        Lutemon lutemon = new Lutemon(textView.getText().toString(), getLutemonColour(view));
        storage.addLutemon(lutemon);
        storage.saveLutemons(this);
        textView.setText("");
        radioGroup.clearCheck();

        Toast toast = Toast.makeText(this, "Uusi lutemon lisätty!", Toast.LENGTH_SHORT);
        toast.show();

    }

    public String getLutemonColour(View view) {
        String colour;

        int id = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(id);

        colour = radioButton.getText().toString();

        return colour;
    }

}