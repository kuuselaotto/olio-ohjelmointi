package com.example.viikko_11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Shopping> shoppings;

    public ShoppingListAdapter(Context context, ArrayList<Shopping> shoppings) {

        this.context = context;
        this.shoppings = shoppings;
    }

    @NonNull
    @Override
    public ShoppingListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ostos_view, parent, false);
        return new ShoppingListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListAdapter.MyViewHolder holder, int position) {

        holder.imgEdit.setImageResource(R.drawable.edit);
        holder.imgRemove.setImageResource(R.drawable.remove);
        holder.shopping.setText(shoppings.get(position).getName());
        holder.txtEdit.setText(shoppings.get(position).getName());

        holder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                Storage storage = Storage.getInstance();
                storage.removeShopping(shoppings.get(pos).getName());
                notifyItemRemoved(pos);
            }
        });

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if (holder.txtEdit.getVisibility() == View.VISIBLE) {
                    Shopping shopping = Storage.getInstance().getShoppingById(pos);
                    String newName = holder.txtEdit.getText().toString();

                    shopping.setName(newName);
                    holder.txtEdit.setVisibility(View.GONE);
                    notifyItemChanged(pos);

                } else {
                    holder.txtEdit.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {return shoppings.size();}

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView shopping, txtEdit;
        private ImageView imgRemove, imgEdit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            shopping = itemView.findViewById(R.id.txtOstos);
            txtEdit = itemView.findViewById(R.id.editName);

            imgRemove = itemView.findViewById(R.id.imgRemove);
            imgEdit = itemView.findViewById(R.id.imgEdit);

        }
    }
}

