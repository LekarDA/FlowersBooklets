package com.example.mazda.flowerbooklets;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mazda.flowerbooklets.models.Flower;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mazda on 12.07.2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Flower> flowers;
    private HashMap<String,String> country;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        FlowerInfoFragment fragmentUserInfo  =  FlowerInfoFragment.newInstance();
        fragmentUserInfo.setFlower(flowers.get(position));
        fragmentUserInfo.setCountry(country);
        return fragmentUserInfo;
    }

    @Override
    public int getCount() {
        return flowers == null ? 0 : flowers.size();
    }

    public void setFlowers(ArrayList<Flower> flowers){
        this.flowers = flowers;
    }

    public void setLanguage(HashMap<String,String> country){
       this.country = country;
    }

}