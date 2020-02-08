package com.mahmoud.bashir.evaluationtask.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.bashir.evaluationtask.R;
import com.mahmoud.bashir.evaluationtask.pojo.categories;
import com.mahmoud.bashir.evaluationtask.pojo.products;
import com.mahmoud.bashir.evaluationtask.ui.Category_details;
import com.mahmoud.bashir.evaluationtask.ui.listing;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categoris_adpt extends RecyclerView.Adapter<Categoris_adpt.ViewHolder> {

    Context context;
    List<categories> list;

    public Categoris_adpt(Context context, List<categories> list) {
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
        categories mlist=list.get(position);
        List<products> m=mlist.getProducts();


        Picasso.get().load(mlist.getCategory_img()).resize(200,150).centerInside().into(holder.categioris_img);
        holder.category_name.setText(mlist.getName());

        holder.itemView.setOnClickListener(v->{
            Intent i=new Intent(context, listing.class);

            i.putExtra("name",mlist.getName());
            Bundle bundle=new Bundle();
            bundle.putSerializable("list", mlist);
            i.putExtras(bundle);
            context.startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categioris_img;
        TextView category_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categioris_img = itemView.findViewById(R.id.categioris_img);
            category_name = itemView.findViewById(R.id.category_name);

        }

    }
}
