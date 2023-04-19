package com.example.viikko12.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viikko12.R;
import com.example.viikko12.Shopping;
import com.example.viikko12.Storage;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Shopping> shoppings = new ArrayList<>();

    public ShoppingListAdapter(ArrayList<Shopping> shoppings, Context context) {
        this.shoppings = shoppings;
        this.context = context;
    }

    @NonNull
    @Override
    public ShoppingListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.shopping_view, parent, false);
        return new ShoppingListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListAdapter.MyViewHolder holder, int position) {

        holder.txtName.setText(shoppings.get(position).getName());

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                Storage storage = Storage.getInstance();
                storage.deleteShopping(shoppings.get(pos).getName());
                notifyItemRemoved(pos);
            }
        });

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                Shopping shopping = Storage.getInstance().getShoppingById(pos);

                if (holder.txtEdit.getVisibility() == View.VISIBLE) {
                    String newName = holder.txtEdit.getText().toString();
                    shopping.setName(newName);
                    holder.txtEdit.setVisibility(View.GONE);
                    notifyItemChanged(pos);

                } else if (holder.txtEdit.getVisibility() == View.GONE) {
                    holder.txtEdit.setVisibility(View.VISIBLE);
                    holder.txtEdit.setText(shopping.getName());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppings.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName, txtEdit;
        private ImageView imgDelete, imgEdit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtOstos);
            txtEdit = itemView.findViewById(R.id.editName);

            imgDelete = itemView.findViewById(R.id.imgRemove);
            imgEdit = itemView.findViewById(R.id.imgEdit);
        }
    }
}
