package com.mahmoud.bashir.evaluationtask.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.bashir.evaluationtask.R;
import com.mahmoud.bashir.evaluationtask.pojo.products;
import com.mahmoud.bashir.evaluationtask.ui.product_details;
import com.squareup.picasso.Picasso;

import java.util.List;

public class details_category_adpt extends RecyclerView.Adapter<details_category_adpt.ViewHolder> {

    Context context;
    List<products> list;

    public details_category_adpt(Context context, List<products> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
         return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        products mproducts=list.get(position);

        Picasso.get().load(mproducts.getProduct_img()).resize(200,150).centerInside().into(holder.categioris_img);
        holder.category_name.setText(mproducts.getName());
        holder.itemView.setOnClickListener(v->{
            Intent i =new Intent(context, product_details.class);
            i.putExtra("id",mproducts.getId());
            i.putExtra("name",mproducts.getName());
            i.putExtra("price",mproducts.getPrice());
            i.putExtra("weight",mproducts.getWeight());
            i.putExtra("pro_img",mproducts.getProduct_img());

            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView categioris_img;
        TextView category_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categioris_img=itemView.findViewById(R.id.categioris_img);
            category_name=itemView.findViewById(R.id.category_name);
        }
    }
}
