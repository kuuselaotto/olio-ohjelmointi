package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.Collections;
import java.util.Comparator;

public class UserListActivity extends AppCompatActivity {

    private UserStorage userStorage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        userStorage = UserStorage.getInstance();

        recyclerView = findViewById(R.id.recyclerViewUsersList);

        // Käytin apuna https://stackoverflow.com/questions/14475556/how-to-sort-arraylist-of-objects
        Collections.sort(userStorage.users, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getLastName().compareTo(t1.getLastName());
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserListAdapter(getApplicationContext(), userStorage.getUser()));

    }
}