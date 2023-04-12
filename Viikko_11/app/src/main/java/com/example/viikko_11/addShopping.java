package com.example.viikko_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class addShopping extends AppCompatActivity {

    private TextView txtName;
    private Storage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shopping);

        txtName = findViewById(R.id.txtName);

        storage = Storage.getInstance();

    }

    public void addShopping(View view) {

        Date date = new Date();
        Shopping shopping = new Shopping(txtName.getText().toString(), date);
        storage.addShopping(shopping);
        txtName.setText("");

    }
}