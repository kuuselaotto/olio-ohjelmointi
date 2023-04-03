package com.example.viikko9;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView name, degreeProgram, email, degrees;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.txtName);
        degreeProgram = itemView.findViewById(R.id.txtDegreeProgram);
        email = itemView.findViewById(R.id.txtEmail);
        degrees = itemView.findViewById(R.id.txtDegrees);
    }

}
