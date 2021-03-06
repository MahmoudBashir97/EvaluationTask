package com.mahmoud.bashir.evaluationtask.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mahmoud.bashir.evaluationtask.Adapters.Categoris_adpt;
import com.mahmoud.bashir.evaluationtask.Adapters.adapter_fragments;
import com.mahmoud.bashir.evaluationtask.Adapters.details_category_adpt;
import com.mahmoud.bashir.evaluationtask.R;
import com.mahmoud.bashir.evaluationtask.Retrofit.ApiInterface;
import com.mahmoud.bashir.evaluationtask.Retrofit.RetrofitClient;
import com.mahmoud.bashir.evaluationtask.pojo.categories;
import com.mahmoud.bashir.evaluationtask.pojo.products;
import com.mahmoud.bashir.evaluationtask.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class Fish_fragment extends Fragment {

    RecyclerView recyclerView;
    ApiInterface apiInterface;
    adapter_fragments adapter_fragments;
    List<products> productsList;


    public Fish_fragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fish_fragment, container, false);


        recyclerView=v.findViewById(R.id.Rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        productsList=new ArrayList<>();

        Retrofit retrofit=RetrofitClient.getInstance();
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
                productsList=models.get(3).getProducts();

                adapter_fragments=new adapter_fragments(productsList,getContext());
                recyclerView.setAdapter(adapter_fragments);
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

        return v;
    }

}
