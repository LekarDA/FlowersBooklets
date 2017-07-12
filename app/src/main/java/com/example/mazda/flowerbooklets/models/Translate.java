package com.example.mazda.flowerbooklets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mazda on 12.07.2017.
 */

public class Translate implements Parcelable{
    @SerializedName("success")
    private boolean success;
    @SerializedName("data")
    private HashMap<String,HashMap<String,String>> data;


    protected Translate(Parcel in) {
        success = in.readByte() != 0;
    }

    public static final Creator<Translate> CREATOR = new Creator<Translate>() {
        @Override
        public Translate createFromParcel(Parcel in) {
            return new Translate(in);
        }

        @Override
        public Translate[] newArray(int size) {
            return new Translate[size];
        }
    };

    public HashMap<String, HashMap<String, String>> getData() {
        return data;
    }

    public void setData(HashMap<String, HashMap<String, String>> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success ? 1 : 0));
    }
}
