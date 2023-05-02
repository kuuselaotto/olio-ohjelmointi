package com.example.lutmonit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutmonit.R;
import com.example.lutmonit.classes.Lutemon;

import java.util.ArrayList;

public class lutemonTrainAdapter extends RecyclerView.Adapter<lutemonTrainAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemonsTraining;

    public lutemonTrainAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemonsTraining = lutemons;
    }

    @NonNull
    @Override
    public lutemonTrainAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lutemon_train_view, parent, false);
        return new lutemonTrainAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull lutemonTrainAdapter.MyViewHolder holder, int position) {
        // Printing lutemons information
        holder.name.setText(lutemonsTraining.get(position).getName() + " (" + lutemonsTraining.get(position).getColor() + ")");
        holder.attack.setText("Hyökkäys: " + lutemonsTraining.get(position).getAttack());
        holder.defense.setText("Puolustus: " + lutemonsTraining.get(position).getDefense());
        holder.health.setText("Elämä: " + lutemonsTraining.get(position).getHealth() + "/" + lutemonsTraining.get(position).getMaxHealth());
        holder.xp.setText("Kokemus: " + lutemonsTraining.get(position).getExperience());
        holder.imgView.setImageResource(lutemonsTraining.get(position).getImage());

        int image = R.drawable.baseline_health_and_safety_24;
        holder.imgTrain.setImageResource(image);

        // Setting up OnClickListener to train lutemon
        holder.imgTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                lutemonsTraining.get(pos).giveExperience();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemonsTraining.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView, imgTrain;
        TextView name, attack, defense, health, xp;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtTrainName);
            attack = itemView.findViewById(R.id.txtTrainAttack);
            defense = itemView.findViewById(R.id.txtTrainDefense);
            xp = itemView.findViewById(R.id.txtTrainExperience);
            imgView = itemView.findViewById(R.id.imgLutemonTrainView);
            health = itemView.findViewById(R.id.txtTrainHealth);
            imgTrain = itemView.findViewById(R.id.imgTrain);

        }
    }
}
