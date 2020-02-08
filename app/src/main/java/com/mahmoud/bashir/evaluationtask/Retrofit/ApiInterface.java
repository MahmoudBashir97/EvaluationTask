package com.mahmoud.bashir.evaluationtask.Retrofit;

import com.mahmoud.bashir.evaluationtask.pojo.categories;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
     @GET("categories")
     Observable<List<categories>> getData();

     @GET("categories/")
     Call<List<categories>> getCategories();

}
