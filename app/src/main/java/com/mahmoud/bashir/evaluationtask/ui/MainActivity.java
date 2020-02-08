package com.mahmoud.bashir.evaluationtask.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.mahmoud.bashir.evaluationtask.Adapters.Categoris_adpt;
import com.mahmoud.bashir.evaluationtask.Adapters.discount_pager_adpt;
import com.mahmoud.bashir.evaluationtask.R;
import com.mahmoud.bashir.evaluationtask.Retrofit.ApiInterface;
import com.mahmoud.bashir.evaluationtask.Retrofit.RetrofitClient;
import com.mahmoud.bashir.evaluationtask.pojo.categories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    Categoris_adpt adpt;
    ApiInterface apiInterface;
    List<categories> mcategories;

    private ViewPager viewPager;
    private discount_pager_adpt pager_adpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_main);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);




        //ViewPager
        viewPager=findViewById(R.id.pager);
        pager_adpt=new discount_pager_adpt(this);
        viewPager.setAdapter(pager_adpt);


        recyclerView=findViewById(R.id.Rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));


        mcategories=new ArrayList<>();

        Retrofit retrofit= RetrofitClient.getInstance();
        apiInterface=retrofit.create(ApiInterface.class);

        Observable<List<categories>> observable=apiInterface.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<List<categories>> listObserver=new Observer<List<categories>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<categories> models) {
                adpt=new Categoris_adpt(MainActivity.this,models);
                recyclerView.setAdapter(adpt);
            }

            @Override
            public void onError(Throwable e) {
                e.getMessage();
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(listObserver);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_icon, menu);
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



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.nav_category:
                Toast.makeText(this, "Already here in Categories View !", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout: Toast.makeText(this, "Logout ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share ur App", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send: Toast.makeText(this, "Communocate with us !", Toast.LENGTH_SHORT).show();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}