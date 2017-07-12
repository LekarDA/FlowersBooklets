package com.example.mazda.flowerbooklets.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by mazda on 12.07.2017.
 */

public class Answer implements Parcelable{
    @SerializedName("success")
    private boolean success;
    @SerializedName("data")
    private ArrayList<Flower> data;

    protected Answer(Parcel in) {
        success = in.readByte() != 0;
        data = in.createTypedArrayList(Flower.CREATOR);
    }

    public static final Creator<Answer> CREATOR = new Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel in) {
            return new Answer(in);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<Flower> getData() {
        return data;
    }

    public void setData(ArrayList<Flower> data) {
        this.data = data;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success ? 1 : 0));
        dest.writeTypedList(data);
    }
}
