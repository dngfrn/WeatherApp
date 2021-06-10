package com.example.weatherapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class HourModel implements Parcelable {
    private String time;
    private Double temp_c;
    private ConditionModel condition;
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Double temp_c) {
        this.temp_c = temp_c;
    }

    public ConditionModel getCondition() {
        return condition;
    }

    public void setCondition(ConditionModel condition) {
        this.condition = condition;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.time);
        dest.writeValue(this.temp_c);
        dest.writeParcelable(this.condition, flags);
    }

    public void readFromParcel(Parcel source) {
        this.time = source.readString();
        this.temp_c = (Double) source.readValue(Double.class.getClassLoader());
        this.condition = source.readParcelable(ConditionModel.class.getClassLoader());
    }

    public HourModel() {
    }

    protected HourModel(Parcel in) {
        this.time = in.readString();
        this.temp_c = (Double) in.readValue(Double.class.getClassLoader());
        this.condition = in.readParcelable(ConditionModel.class.getClassLoader());
    }

    public static final Parcelable.Creator<HourModel> CREATOR = new Parcelable.Creator<HourModel>() {
        @Override
        public HourModel createFromParcel(Parcel source) {
            return new HourModel(source);
        }

        @Override
        public HourModel[] newArray(int size) {
            return new HourModel[size];
        }
    };
}
