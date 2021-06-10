package com.example.weatherapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.MainActivity;
import com.example.weatherapp.R;
import com.example.weatherapp.model.ForecastDayModel;

import java.util.ArrayList;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ListViewHolder>{
    ArrayList<ForecastDayModel> listforecast=new ArrayList<>();
    private OnForecastListener mOnForecastListener;

    public ForecastAdapter(ArrayList<ForecastDayModel> listforecast, OnForecastListener mOnForecastListener) {
        this.listforecast = listforecast;
        this.mOnForecastListener = mOnForecastListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_forecast, parent,false);
        ListViewHolder listViewHolder = new ListViewHolder(view, mOnForecastListener);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.tv_date.setText(listforecast.get(position).getDate());
        holder.tv_avgtemp.setText(Double.toString(listforecast.get(position).getDay().getAvgtemp_c()));
        holder.tv_condition.setText(listforecast.get(position).getDay().getCondition().getText());
    }

    @Override
    public int getItemCount() {
        return listforecast.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_date, tv_avgtemp, tv_condition;
        OnForecastListener onForecastListener;
        public ListViewHolder(@NonNull View itemView, OnForecastListener onForecastListener) {
            super(itemView);

            tv_date=itemView.findViewById(R.id.tv_date);
            tv_avgtemp=itemView.findViewById(R.id.tv_avgtemp);
            tv_condition=itemView.findViewById(R.id.tv_condition);
            this.onForecastListener=onForecastListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onForecastListener.onForecastClick(getAdapterPosition());
        }
    }

    public interface OnForecastListener{
        void onForecastClick(int position);
    }

}
