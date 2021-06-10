package com.example.weatherapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DayModel implements Parcelable {
    private Double maxtemp_c;
    private Double mintemp_c;
    private Double avgtemp_c;
    private Double maxwind_kph;
    private Double totalprecip_mm;
    public Double getMaxwind_kph() {
        return maxwind_kph;
    }

    public void setMaxwind_kph(Double maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }

    public Double getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public void setTotalprecip_mm(Double totalprecip_mm) {
        this.totalprecip_mm = totalprecip_mm;
    }

    private ConditionModel condition;
    public ConditionModel getCondition() {
        return condition;
    }

    public void setCondition(ConditionModel condition) {
        this.condition = condition;
    }

    public Double getMaxtemp_c() {
        return maxtemp_c;
    }

    public void setMaxtemp_c(Double maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public Double getMintemp_c() {
        return mintemp_c;
    }

    public void setMintemp_c(Double mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public Double getAvgtemp_c() {
        return avgtemp_c;
    }

    public void setAvgtemp_c(Double avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.maxtemp_c);
        dest.writeValue(this.mintemp_c);
        dest.writeValue(this.avgtemp_c);
        dest.writeValue(this.maxwind_kph);
        dest.writeValue(this.totalprecip_mm);
        dest.writeParcelable(this.condition, flags);
    }

    public void readFromParcel(Parcel source) {
        this.maxtemp_c = (Double) source.readValue(Double.class.getClassLoader());
        this.mintemp_c = (Double) source.readValue(Double.class.getClassLoader());
        this.avgtemp_c = (Double) source.readValue(Double.class.getClassLoader());
        this.maxwind_kph = (Double) source.readValue(Double.class.getClassLoader());
        this.totalprecip_mm = (Double) source.readValue(Double.class.getClassLoader());
        this.condition = source.readParcelable(ConditionModel.class.getClassLoader());
    }

    public DayModel() {
    }

    protected DayModel(Parcel in) {
        this.maxtemp_c = (Double) in.readValue(Double.class.getClassLoader());
        this.mintemp_c = (Double) in.readValue(Double.class.getClassLoader());
        this.avgtemp_c = (Double) in.readValue(Double.class.getClassLoader());
        this.maxwind_kph = (Double) in.readValue(Double.class.getClassLoader());
        this.totalprecip_mm = (Double) in.readValue(Double.class.getClassLoader());
        this.condition = in.readParcelable(ConditionModel.class.getClassLoader());
    }

    public static final Parcelable.Creator<DayModel> CREATOR = new Parcelable.Creator<DayModel>() {
        @Override
        public DayModel createFromParcel(Parcel source) {
            return new DayModel(source);
        }

        @Override
        public DayModel[] newArray(int size) {
            return new DayModel[size];
        }
    };
}
