package com.example.weatherapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ForecastDayModel implements Parcelable {
    private String date;
    private DayModel day;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DayModel getDay() {
        return day;
    }

    public void setDay(DayModel day) {
        this.day = day;
    }

    public ArrayList<HourModel> getHour() {
        return hour;
    }

    public void setHour(ArrayList<HourModel> hour) {
        this.hour = hour;
    }

    private ArrayList<HourModel>hour;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeParcelable(this.day, flags);
        dest.writeTypedList(this.hour);
    }

    public void readFromParcel(Parcel source) {
        this.date = source.readString();
        this.day = source.readParcelable(DayModel.class.getClassLoader());
        this.hour = source.createTypedArrayList(HourModel.CREATOR);
    }

    public ForecastDayModel() {
    }

    protected ForecastDayModel(Parcel in) {
        this.date = in.readString();
        this.day = in.readParcelable(DayModel.class.getClassLoader());
        this.hour = in.createTypedArrayList(HourModel.CREATOR);
    }

    public static final Parcelable.Creator<ForecastDayModel> CREATOR = new Parcelable.Creator<ForecastDayModel>() {
        @Override
        public ForecastDayModel createFromParcel(Parcel source) {
            return new ForecastDayModel(source);
        }

        @Override
        public ForecastDayModel[] newArray(int size) {
            return new ForecastDayModel[size];
        }
    };
}
