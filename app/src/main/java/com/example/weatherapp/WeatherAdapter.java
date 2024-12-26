// WeatherAdapter.java
package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WeatherActivity> weatherArrayList;

    public WeatherAdapter(Context context, ArrayList<WeatherActivity> weatherArrayList) {
        this.context = context;
        this.weatherArrayList = weatherArrayList;
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weather_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {
        WeatherActivity modal = weatherArrayList.get(position);
        holder.temperatureTV.setText(modal.getTemperature() + "℃");
        Picasso.get().load(modal.getIcon()).into(holder.conditionIV);
        holder.feelsTV.setText("Ощущается как: " + modal.getFeelsLike() + "℃");

        SimpleDateFormat inputDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat outputDate = new SimpleDateFormat("HH:mm");
        try {
            Date t = inputDate.parse(modal.getTime());
            holder.timeTV.setText(outputDate.format(t));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return weatherArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView feelsTV, temperatureTV, timeTV;
        private ImageView conditionIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            feelsTV = itemView.findViewById(R.id.FeelsLikeTV);
            temperatureTV = itemView.findViewById(R.id.TemperatureTV);
            timeTV = itemView.findViewById(R.id.TimeTV);
            conditionIV = itemView.findViewById(R.id.IVCondition);
        }
    }
}
