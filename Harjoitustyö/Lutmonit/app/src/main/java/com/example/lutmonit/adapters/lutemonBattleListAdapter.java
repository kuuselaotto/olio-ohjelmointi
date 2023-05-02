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

public class lutemonBattleListAdapter extends RecyclerView.Adapter<lutemonBattleListAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemonsBattle;
    private String place = "Battle";

    public lutemonBattleListAdapter(Context context, ArrayList<Lutemon> lutemonsBattle) {
        this.context = context;
        this.lutemonsBattle = lutemonsBattle;
    }

    @NonNull
    @Override
    public lutemonBattleListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lutemon_battle_view, parent, false);
        return new lutemonBattleListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull lutemonBattleListAdapter.MyViewHolder holder, int position) {
        // Printing lutemons information
        holder.txtName.setText(lutemonsBattle.get(position).getName() + " (" + lutemonsBattle.get(position).getColor() +")");
        holder.txtAttack.setText("Hyökkäys: " + lutemonsBattle.get(position).getAttack());
        holder.txtDefense.setText("Puolustus: " + lutemonsBattle.get(position).getDefense());
        holder.txtHealth.setText("Elämä: " + lutemonsBattle.get(position).getHealth() + "/" + lutemonsBattle.get(position).getMaxHealth());
        holder.txtXp.setText("Kokemus: " + lutemonsBattle.get(position).getExperience());
        holder.imgView.setImageResource(lutemonsBattle.get(position).getImage());

        // Setting up OnCLickListener to move lutemon to home
        holder.imgMoveHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toPlace = "Home";
                int pos = holder.getAdapterPosition();
                Storage.getInstance().moveLutemon(lutemonsBattle.get(pos).getLutemon(), place, toPlace);
                notifyItemRemoved(pos);
            }
        });
        // Setting up OnClickListener to move lutemon to training
        holder.imgMoveTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toPlace = "Training";
                int pos = holder.getAdapterPosition();
                Storage.getInstance().moveLutemon(lutemonsBattle.get(pos).getLutemon(), place, toPlace);
                notifyItemRemoved(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemonsBattle.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName, txtAttack, txtDefense, txtHealth, txtXp;
        private ImageView imgView, imgMoveHome, imgMoveTraining;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtBattleName);
            txtAttack = itemView.findViewById(R.id.txtBattleAttack);
            txtDefense = itemView.findViewById(R.id.txtBattleDefense);
            txtHealth = itemView.findViewById(R.id.txtBattleHealth);
            txtXp = itemView.findViewById(R.id.txtBattleExperience);

            imgView = itemView.findViewById(R.id.imgBattleView);
            imgMoveHome = itemView.findViewById(R.id.imgMoveHome);
            imgMoveTraining = itemView.findViewById(R.id.imgBattleTraining);

        }
    }
}
