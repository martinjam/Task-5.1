package com.example.task51;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder>{
    private List<Places> placesList;
    private Context context;
    private OnRowClickListener listener;

    public PlacesAdapter(List<Places> placesList, Context context, OnRowClickListener clickListener) {
        this.placesList = placesList;
        this.context = context;
        this.listener = clickListener;
    }
    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.places_row, parent, false);
        return new PlacesViewHolder(itemView, listener);
    }

    public interface OnRowClickListener {
        void onItemClick2 (int position);
    }
    public class PlacesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView placesImageView;
        public OnRowClickListener onRowClickListener;

        public PlacesViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            placesImageView = itemView.findViewById(R.id.placesImageView);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            onRowClickListener.onItemClick2(getAdapterPosition());
        }
    }
    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder holder, int position) {
        holder.placesImageView.setImageResource(placesList.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return placesList.size();
    }
}