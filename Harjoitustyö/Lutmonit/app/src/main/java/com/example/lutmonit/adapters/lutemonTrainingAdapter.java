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

public class lutemonTrainingAdapter extends RecyclerView.Adapter<lutemonTrainingAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemonsTraining;
    private String place = "Training";

    public lutemonTrainingAdapter(Context context, ArrayList<Lutemon> lutemonsTraining) {
        this.context = context;
        this.lutemonsTraining = lutemonsTraining;
    }

    @NonNull
    @Override
    public lutemonTrainingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lutemon_training_view, parent, false);
        return new lutemonTrainingAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull lutemonTrainingAdapter.MyViewHolder holder, int position) {
        // Printing lutemons information
        holder.txtName.setText(lutemonsTraining.get(position).getName() + " (" + lutemonsTraining.get(position).getColor() +")");
        holder.txtAttack.setText("Hyökkäys: " + lutemonsTraining.get(position).getAttack());
        holder.txtDefense.setText("Puolustus: " + lutemonsTraining.get(position).getDefense());
        holder.txtHealth.setText("Elämä: " + lutemonsTraining.get(position).getHealth() + "/" + lutemonsTraining.get(position).getMaxHealth());
        holder.txtXp.setText("Kokemus: " + lutemonsTraining.get(position).getExperience());
        holder.imgView.setImageResource(lutemonsTraining.get(position).getImage());

        // Setting up OnClickListener to move lutemon to home
        holder.imgMoveHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toPlace = "Home";
                int pos = holder.getAdapterPosition();
                Storage.getInstance().moveLutemon(lutemonsTraining.get(pos).getLutemon(), place, toPlace);
                notifyItemRemoved(pos);
            }
        });
        // Setting up OnClickListener to move lutemon to battle
        holder.imgMoveBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toPlace = "Battle";
                int pos = holder.getAdapterPosition();
                Storage.getInstance().moveLutemon(lutemonsTraining.get(pos).getLutemon(), place, toPlace);
                notifyItemRemoved(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemonsTraining.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName, txtAttack, txtDefense, txtHealth, txtXp;
        private ImageView imgView, imgMoveHome, imgMoveBattle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtTrainingName);
            txtAttack = itemView.findViewById(R.id.txtTrainingAttack);
            txtDefense = itemView.findViewById(R.id.txtTrainingDefense);
            txtHealth = itemView.findViewById(R.id.txtTrainingHealth);
            txtXp = itemView.findViewById(R.id.txtTrainingExperience);

            imgView = itemView.findViewById(R.id.imgTrainingView);
            imgMoveHome = itemView.findViewById(R.id.imgMoveHome);
            imgMoveBattle = itemView.findViewById(R.id.imgMoveBattle);
        }

    }
}
