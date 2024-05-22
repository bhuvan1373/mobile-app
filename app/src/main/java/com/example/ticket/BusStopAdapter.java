package com.example.ticket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BusStopAdapter extends RecyclerView.Adapter<BusStopAdapter.BusStopViewHolder> {

    private List<BusStop> busStopList;

    public BusStopAdapter(List<BusStop> busStopList) {
        this.busStopList = busStopList;
    }

    @NonNull
    @Override
    public BusStopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bus_stop, parent, false);
        return new BusStopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusStopViewHolder holder, int position) {
        BusStop busStop = busStopList.get(position);
        holder.busStopNameTextView.setText(busStop.getStopName());
        holder.busNumberTextView.setText(busStop.getBusNumber());
    }

    @Override
    public int getItemCount() {
        return busStopList.size();
    }

    public static class BusStopViewHolder extends RecyclerView.ViewHolder {
        TextView busStopNameTextView;
        TextView busNumberTextView;

        public BusStopViewHolder(@NonNull View itemView) {
            super(itemView);
            busStopNameTextView = itemView.findViewById(R.id.busStopNameTextView);
            busNumberTextView = itemView.findViewById(R.id.busNumberTextView);
        }
    }
}
