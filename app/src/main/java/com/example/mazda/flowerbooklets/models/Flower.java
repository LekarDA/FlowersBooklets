package com.example.mazda.flowerbooklets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mazda on 12.07.2017.
 */

public class Flower implements Parcelable{
    @SerializedName("name")
    private String name;
    @SerializedName("best season")
    private String best_season;
    @SerializedName("image link")
    private String image_link;


    protected Flower(Parcel in) {
        name = in.readString();
        best_season = in.readString();
        image_link = in.readString();
    }

    public static final Creator<Flower> CREATOR = new Creator<Flower>() {
        @Override
        public Flower createFromParcel(Parcel in) {
            return new Flower(in);
        }

        @Override
        public Flower[] newArray(int size) {
            return new Flower[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBest_season() {
        return best_season;
    }

    public void setBest_season(String best_season) {
        this.best_season = best_season;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(best_season);
        dest.writeString(image_link);
    }
}
