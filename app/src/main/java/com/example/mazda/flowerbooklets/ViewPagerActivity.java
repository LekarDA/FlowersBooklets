package com.example.mazda.flowerbooklets;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.mazda.flowerbooklets.models.Answer;
import com.example.mazda.flowerbooklets.models.Flower;
import com.example.mazda.flowerbooklets.models.Translate;
import com.example.mazda.flowerbooklets.rest.RetrofitConfig;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mazda on 12.07.2017.
 */

public class ViewPagerActivity extends AppCompatActivity {

    private static final String FLOWERS = "FLOWERS";
    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapter vpAdapter;
    private ArrayList<Flower> flowers;
    private String countryCode;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getResources().getString(R.string.title));
        viewPager = (ViewPager) findViewById(R.id.vpContainer);
        vpAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        countryCode = Resources.getSystem().getConfiguration().locale.getLanguage();
        requestGetTranslate();
        if(savedInstanceState==null){
            requestGetFlowers();
        }
        else {
            flowers = savedInstanceState.getParcelableArrayList(FLOWERS);
            vpAdapter.setFlowers(flowers);
            viewPager.setAdapter(vpAdapter);
        }
    }

    private void requestGetTranslate() {
        Call<Translate> callback = RetrofitConfig.getService().getTranslate();
        callback.enqueue(new Callback<Translate>() {
            @Override
            public void onResponse(Call<Translate> call, Response<Translate> response) {
                if(response.body()!= null){
                    vpAdapter.setLanguage(response.body().getData().get(countryCode));
                }
            }

            @Override
            public void onFailure(Call<Translate> call, Throwable t) {
                Toast.makeText(ViewPagerActivity.this,"Check internet connection",Toast.LENGTH_SHORT).show();
                requestGetTranslate();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(FLOWERS,flowers);
    }

    private void requestGetFlowers() {
        Call<Answer> callback = RetrofitConfig.getService().getFlowers();
        callback.enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(Call<Answer> call, Response<Answer> response) {
                if (response.body()!= null){
                    vpAdapter.setFlowers(response.body().getData());
                    viewPager.setAdapter(vpAdapter);
                    flowers = response.body().getData();
                }
            }

            @Override
            public void onFailure(Call<Answer> call, Throwable t) {
                Toast.makeText(ViewPagerActivity.this,"Check internet connection",Toast.LENGTH_SHORT).show();
                requestGetFlowers();
            }
        });
    }
}
