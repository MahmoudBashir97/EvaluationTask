package com.mahmoud.bashir.evaluationtask.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mahmoud.bashir.evaluationtask.R;
import com.squareup.picasso.Picasso;

public class product_details extends AppCompatActivity {

    String id,name,price,weight,pro_img;

    ImageView imgv;
    TextView txtname,txt_price,txt_weight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_category_item);

        // init views
        imgv=findViewById(R.id.imgv);
        txt_price=findViewById(R.id.price);
        txt_weight=findViewById(R.id.weight);
        txtname=findViewById(R.id.name);


        id=getIntent().getStringExtra("id");
        name=getIntent().getStringExtra("name");
        price=getIntent().getStringExtra("price");
        weight=getIntent().getStringExtra("weight");
        pro_img=getIntent().getStringExtra("pro_img");

        Toast.makeText(this, ""+pro_img, Toast.LENGTH_SHORT).show();

       Picasso.get().load(pro_img)
               .placeholder(R.drawable.ic_launcher_background)
               .resize(380,160)
               .centerInside()
               .into(imgv);
        txtname.setText(name);
        txt_price.setText(price);
        txt_weight.setText(weight);

    }
}
