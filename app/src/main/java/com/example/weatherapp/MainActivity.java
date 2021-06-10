package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;

import com.example.weatherapp.Retrofit.APIClient;
import com.example.weatherapp.adapter.ForecastAdapter;
import com.example.weatherapp.model.ConditionModel;
import com.example.weatherapp.model.ForecastDayModel;
import com.example.weatherapp.model.WeatherModel;

import java.text.BreakIterator;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ForecastAdapter.OnForecastListener {
    private static final String TAG = "MyActivity";
    TextView tv_location, tv_wind, tv_pressure, tv_precip, tv_humidity, tv_cloud, tv_gust, tv_temp;
    ArrayList<ForecastDayModel> forecastday=new ArrayList<>();
    private RecyclerView recyclerView;
    private ForecastAdapter forecastAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_location = findViewById(R.id.tv_location);
        tv_wind = findViewById(R.id.tv_wind);
        tv_pressure = findViewById(R.id.tv_pressure);
        tv_precip= findViewById(R.id.tv_precip);
        tv_humidity = findViewById(R.id.tv_humidity);
        tv_cloud = findViewById(R.id.tv_cloud);
        tv_gust = findViewById(R.id.tv_gust);
        tv_temp = findViewById(R.id.tv_temp);



        recyclerView = findViewById(R.id.forecast_list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mainActivity = this;
        getDataFromApi();
        getForecastFromApi();
    }

    private void getDataFromApi(){
        APIClient.endpoint().getData()
                .enqueue(new Callback<WeatherModel>() {
                    @Override
                    public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                        tv_location.setText("Location: "+response.body().getLocation().getName());
                        tv_wind.setText("Wind: "+Double.toString(response.body().getCurrent().getWind_kph()));
                        tv_pressure.setText("Pressure: "+Double.toString(response.body().getCurrent().getPressure_mb()));
                        tv_precip.setText("Precipitation: "+Double.toString(response.body().getCurrent().getPrecip_mm()));
                        tv_humidity.setText("Humidity: "+Double.toString(response.body().getCurrent().getHumidity()));
                        tv_cloud.setText("Cloud: "+Double.toString(response.body().getCurrent().getCloud()));
                        tv_gust.setText("Gust: "+Double.toString(response.body().getCurrent().getGust_kph()));

                        tv_temp.setText("Temperature: "+Double.toString(response.body().getCurrent().getTemp_c()));
                    }

                    @Override
                    public void onFailure(Call<WeatherModel> call, Throwable t) {

                    }
                });

    }

    private void getForecastFromApi(){
        APIClient.endpoint().getForecast()
                .enqueue(new Callback<WeatherModel>() {
                    @Override
                    public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                        forecastday=response.body().getForecast().getForecastday();
                        forecastAdapter = new ForecastAdapter(forecastday, mainActivity);
                        recyclerView.setAdapter(forecastAdapter);
                    }

                    @Override
                    public void onFailure(Call<WeatherModel> call, Throwable t) {
                    }
                });
    }

    @Override
    public void onForecastClick(int position) {
        Intent intent = new Intent(this,DetailForecastActivity.class);
        intent.putExtra("ForecastDay", forecastday.get(position));
        startActivity(intent);
        Log.d(TAG, "onForecastClick: clicked");
    }
}