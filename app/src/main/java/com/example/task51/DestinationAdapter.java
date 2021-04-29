package com.example.task51;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>{
    private List<Destination> destinationList;
    private Context context;
    private OnRowClickListener listener;

    public DestinationAdapter(List<Destination> destinationList, Context context, OnRowClickListener clickListener) {
        this.destinationList = destinationList;
        this.context = context;
        this.listener = clickListener;
    }
    @NonNull
    @Override
    public DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.destination_column, parent, false);
        return new DestinationViewHolder(itemView, listener);
    }

    public interface OnRowClickListener {
        void onItemClick (int position);
    }
    public class DestinationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView destinationImageView;
        public OnRowClickListener onRowClickListener;

        public DestinationViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            destinationImageView = itemView.findViewById(R.id.destinationImageView);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }
    @Override
    public void onBindViewHolder(@NonNull DestinationViewHolder holder, int position) {
        holder.destinationImageView.setImageResource(destinationList.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return destinationList.size();
    }
}