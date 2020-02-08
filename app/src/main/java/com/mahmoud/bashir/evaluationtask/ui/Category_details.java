package com.mahmoud.bashir.evaluationtask.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.bashir.evaluationtask.Adapters.details_category_adpt;
import com.mahmoud.bashir.evaluationtask.R;
import com.mahmoud.bashir.evaluationtask.pojo.products;

import java.util.ArrayList;
import java.util.List;

public class Category_details extends AppCompatActivity {

    RecyclerView recyclerView;
    details_category_adpt adpt;
    List<products> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_category);

        recyclerView=findViewById(R.id.Rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(Category_details.this,2));


        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        list=(List<products>)bundle.getSerializable("list");
/*
        list=new ArrayList<>();

        products pro=new products(id,name,weight,price,pro_img);
        list.add(pro);*/
        adpt=new details_category_adpt(this,list);
        recyclerView.setAdapter(adpt);
    }
}
