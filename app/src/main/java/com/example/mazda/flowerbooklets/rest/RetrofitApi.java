package com.example.mazda.flowerbooklets.rest;

import com.example.mazda.flowerbooklets.models.Answer;
import com.example.mazda.flowerbooklets.models.Translate;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mazda on 12.07.2017.
 */

public interface RetrofitApi {
    @GET("/getFlowers/")
    Call<Answer> getFlowers();
    @GET("/getTranslate/")
    Call<Translate> getTranslate();
}
