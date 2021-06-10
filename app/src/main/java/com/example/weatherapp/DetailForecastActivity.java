package com.example.weatherapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.adapter.DetailForecastAdapter;
import com.example.weatherapp.model.ForecastDayModel;
import com.example.weatherapp.model.HourModel;

import java.util.ArrayList;

public class DetailForecastActivity extends AppCompatActivity {
    TextView tv_date, tv_maxtemp, tv_avgtemp, tv_mintemp, tv_totalprecip;
    private RecyclerView recyclerView;
    private DetailForecastAdapter detailForecastAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<HourModel> listhour=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_forecast);
        ForecastDayModel forecastDay = getIntent().getParcelableExtra("ForecastDay");
        recyclerView = findViewById(R.id.list_hour);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        tv_date = findViewById(R.id.tv_date);
        tv_maxtemp = findViewById(R.id.tv_maxtemp);
        tv_avgtemp = findViewById(R.id.tv_avgtemp);
        tv_mintemp = findViewById(R.id.tv_mintemp);
        tv_totalprecip = findViewById(R.id.tv_totalprecip);

        tv_date.setText(forecastDay.getDate());
        tv_maxtemp.setText("Max Temp: "+Double.toString(forecastDay.getDay().getMaxtemp_c()));
        tv_avgtemp.setText("Avg Temp: "+Double.toString(forecastDay.getDay().getAvgtemp_c()));
        tv_mintemp.setText("Min Temp: "+Double.toString(forecastDay.getDay().getMintemp_c()));
        tv_totalprecip.setText("Total Prec: "+Double.toString(forecastDay.getDay().getTotalprecip_mm()));

        listhour=forecastDay.getHour();
        detailForecastAdapter = new DetailForecastAdapter(listhour);
        recyclerView.setAdapter(detailForecastAdapter);
    }

}
