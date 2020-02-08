package com.mahmoud.bashir.evaluationtask.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.bashir.evaluationtask.R;
import com.mahmoud.bashir.evaluationtask.pojo.categories;
import com.mahmoud.bashir.evaluationtask.pojo.products;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adapter_fragments extends RecyclerView.Adapter<adapter_fragments.ViewHolder> {

    List<products> list;
    Context context;

    public adapter_fragments(List<products> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.details_category_item,parent,false);
         return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        products ls=list.get(position);

            Picasso.get().load(ls.getProduct_img()).resize(200,160).centerInside().into(holder.imgv);
            holder.name.setText(ls.getName());
            holder.weight.setText(ls.getWeight());
            holder.price.setText(ls.getPrice());
            if (holder.toggle_btn.isChecked()){
                Toast.makeText(context, ls.getName()+" "+"added to your buy list", Toast.LENGTH_SHORT).show();
            }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv;
        TextView name,weight,price;
        ToggleButton toggle_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgv=itemView.findViewById(R.id.imgv);
            name=itemView.findViewById(R.id.name);
            weight=itemView.findViewById(R.id.weight);
            price=itemView.findViewById(R.id.price);
            toggle_btn=itemView.findViewById(R.id.toggle_btn);

        }
    }
}
