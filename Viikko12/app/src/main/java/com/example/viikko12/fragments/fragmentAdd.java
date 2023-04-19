package com.example.viikko12.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viikko12.R;
import com.example.viikko12.Shopping;
import com.example.viikko12.Storage;

import java.util.Date;

public class fragmentAdd extends Fragment {

    private Button btnAdd;
    private TextView txtName;
    private CheckBox cbImportant;
    private boolean important;
    private Storage storage;

    public fragmentAdd() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        btnAdd = view.findViewById(R.id.btnAdd);
        txtName = view.findViewById(R.id.txtName);
        cbImportant = view.findViewById(R.id.cbImportant);

        storage = Storage.getInstance();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbImportant.isChecked()) {
                    important = true;
                } else {
                    important = false;
                }
                Date date = new Date();

                Shopping shopping = new Shopping(txtName.getText().toString(), date, important);
                storage.addShopping(shopping);
                txtName.setText("");
                cbImportant.setChecked(false);
                Toast toast = Toast.makeText(getContext(), "Uusi ostos lisätty!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return view;
    }
}