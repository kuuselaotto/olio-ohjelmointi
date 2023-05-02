package com.example.lutmonit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutmonit.classes.Lutemon;
import com.example.lutmonit.R;
import com.example.lutmonit.classes.Storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class lutemonHomeListAdapter extends RecyclerView.Adapter<lutemonHomeListAdapter.MyViewHolder> {

    private ArrayList<Lutemon> lutemonsHome;
    private Context context;
    private String place = "Home";

    public lutemonHomeListAdapter(ArrayList<Lutemon> lutemonsHome, Context context) {

        this.lutemonsHome = lutemonsHome;
        this.context = context;
    }

    @NonNull
    @Override
    public lutemonHomeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lutemon_home_view, parent, false);
        return new lutemonHomeListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull lutemonHomeListAdapter.MyViewHolder holder, int position) {
        // Printing lutemons information
        holder.txtName.setText(lutemonsHome.get(position).getName() + " (" + lutemonsHome.get(position).getColor() +")");
        holder.txtAttack.setText("Hyökkäys: " + lutemonsHome.get(position).getAttack());
        holder.txtDefense.setText("Puolustus: " + lutemonsHome.get(position).getDefense());
        holder.txtHealth.setText("Elämä: " + lutemonsHome.get(position).getHealth() + "/" + lutemonsHome.get(position).getMaxHealth());
        holder.txtXp.setText("Kokemus: " + lutemonsHome.get(position).getExperience());
        holder.imgView.setImageResource(lutemonsHome.get(position).getImage());

        // Setting up OnClickListener to move lutemon to battle
        holder.imgMoveBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toPlace = "Battle";
                int pos = holder.getAdapterPosition();
                Storage.getInstance().moveLutemon(lutemonsHome.get(pos).getLutemon(), place, toPlace);
                notifyItemRemoved(pos);

            }
        });
        // Setting up OnClickListener to move lutemon to training
        holder.imgMoveTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toPlace = "Training";
                int pos = holder.getAdapterPosition();
                Storage.getInstance().moveLutemon(lutemonsHome.get(pos).getLutemon(), place, toPlace);
                notifyItemRemoved(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemonsHome.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtAttack, txtDefense, txtHealth, txtXp;
        private ImageView imgView, imgMoveBattle, imgMoveTraining;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtHomeName);
            txtAttack = itemView.findViewById(R.id.txtHomeAttack);
            txtDefense = itemView.findViewById(R.id.txtHomeDefense);
            txtHealth = itemView.findViewById(R.id.txtHomeHealth);
            txtXp = itemView.findViewById(R.id.txtHomeExperience);

            imgView = itemView.findViewById(R.id.imgHomeView);
            imgMoveBattle = itemView.findViewById(R.id.imgMoveBattle);
            imgMoveTraining = itemView.findViewById(R.id.imgMoveTraining);
        }
    }
}