package com.example.viikko_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Storage storage;
    private ShoppingListAdapter adapter;
    private ImageView imgTime;
    private TextView txtA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgTime = findViewById(R.id.imgTime);
        txtA = findViewById(R.id.txtA);

        storage = Storage.getInstance();
        adapter = new ShoppingListAdapter(this, storage.getShoppings());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        imgTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                storage.sortByTime();
                adapter = new ShoppingListAdapter(getApplicationContext(), storage.getShoppings());
                recyclerView.setAdapter(adapter);
            }
        });

        txtA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                storage.sortByNames();
                adapter = new ShoppingListAdapter(getApplicationContext(), storage.getShoppings());
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
    public void switchToAddShopping(View view) {

        Intent intent = new Intent(this, addShopping.class);
        startActivity(intent);
    }
}