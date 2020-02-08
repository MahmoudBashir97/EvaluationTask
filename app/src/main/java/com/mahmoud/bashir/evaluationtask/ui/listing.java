package com.mahmoud.bashir.evaluationtask.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.mahmoud.bashir.evaluationtask.Adapters.ViewPager_Frag_adpt;
import com.mahmoud.bashir.evaluationtask.R;
import com.mahmoud.bashir.evaluationtask.fragments.Fish_fragment;
import com.mahmoud.bashir.evaluationtask.fragments.FruitsFragment;
import com.mahmoud.bashir.evaluationtask.fragments.Meats_fragment;
import com.mahmoud.bashir.evaluationtask.fragments.VegitablesFragment;
import com.mahmoud.bashir.evaluationtask.pojo.categories;
import com.mahmoud.bashir.evaluationtask.pojo.products;

import java.util.ArrayList;
import java.util.List;

public class listing extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView arrow_back;
    private TextView toolbar_title;
    List<categories> list;

    categories mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        tabLayout=(TabLayout)findViewById(R.id.tablay);

        viewPager=(ViewPager)findViewById(R.id.view_pp);
        toolbar_title=findViewById(R.id.toolbar_title);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //back arrow
        arrow_back=findViewById(R.id.arrow_back);
        arrow_back.setOnClickListener(v->{
            Intent i=new Intent(listing.this,MainActivity.class);
            startActivity(i);
            finish();
        });


        list=new ArrayList<>();
        // get data By using Bundle

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        mlist= (categories) bundle.getSerializable("list");


        for (int i=0;i<mlist.getName().length();i++){
            list.add(i,mlist);
        }


        ViewPager_Frag_adpt adapter=new ViewPager_Frag_adpt(getSupportFragmentManager());

        String name = getIntent().getStringExtra("name");
        if (name.equals("Meats") || name.equals("Seafood") ){
            toolbar_title.setText("Meats & Seafood");

             adapter.addFragment(new Meats_fragment(),"Meats");
             adapter.addFragment(new Fish_fragment(),"Fish");


        }else if (name.equals("Vegetables") || name.equals("Fruits")){
            toolbar_title.setText("Vegetables & Fruits");

            adapter.addFragment(new VegitablesFragment(),"Vegetables");
            adapter.addFragment(new FruitsFragment(),"Fruits");
        }

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.listing_menu_icon, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.search:
                Toast.makeText(this, "searching", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shopp_ing:
                Toast.makeText(this, "shopping", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}