package com.example.chatwise_api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Product> products;
    public CustomAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Product product = products.get(position);

        holder.product_text.setText(product.getTitle());
        holder.description_text.setText(product.getDescription());

//        // Load the product image using Glide library
//        Glide.with(holder.itemView)
//                .load(product.getThumbnail())
//                .into(holder.imageView);

        // place image using picasso
        Picasso.get().load(product.getThumbnail()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView product_text;
        TextView description_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            product_text = itemView.findViewById(R.id.product_text);
            description_text = itemView.findViewById(R.id.description_text);
        }
    }
}
