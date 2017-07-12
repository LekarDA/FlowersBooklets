package com.example.mazda.flowerbooklets;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mazda.flowerbooklets.models.Flower;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

/**
 * Created by mazda on 12.07.2017.
 */

public class FlowerInfoFragment extends Fragment {

    private static final String FLOWER = "FLOWER";
    private Flower flower;
    private ImageView photo;
    private TextView name, best_season;
    private Context context;
    private HashMap<String, String> country;
    private View view;

    public static FlowerInfoFragment newInstance() {

        Bundle args = new Bundle();

        FlowerInfoFragment fragment = new FlowerInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.flower_info, container, false);
        name = (TextView) view.findViewById(R.id.flower_name);
        photo = (ImageView) view.findViewById(R.id.photo);
        best_season = (TextView) view.findViewById(R.id.best_season);
        context = view.getContext();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null)
            flower = savedInstanceState.getParcelable(FLOWER);
        if (flower != null && country != null) {
            name.setText(country.get(flower.getName()));
            best_season.setText(country.get(flower.getBest_season()));
            Picasso.with(context).load(flower.getImage_link()).into(photo);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(FLOWER, flower);
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public void setCountry(HashMap<String, String> country) {
        this.country = country;
        if (flower != null && view != null) {
            name.setText(country.get(flower.getName()));
            best_season.setText(country.get(flower.getBest_season()));
            Picasso.with(context).load(flower.getImage_link()).into(photo);
        }
    }
}
