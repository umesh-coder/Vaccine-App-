package com.example.vaccineapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccineapp.databinding.RecyclerViewItemBinding;


public class VaccineCustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private VaccineModel[] vaccineModels;
    public static ItemClickListener clickListener;

    public VaccineCustomAdapter(VaccineModel[] vaccineModels) {
        this.vaccineModels = vaccineModels;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflate the layout using view binding
        RecyclerViewItemBinding binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        // Create a new view holder
        ViewHolder viewHolder = new ViewHolder(binding);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // Get the data item for this position
        VaccineModel vaccineModel = vaccineModels[position];

        // Cast the view holder to the custom ViewHolder class
        ViewHolder viewHolder = (ViewHolder) holder;

        // Set the data to the views in the list item view
        viewHolder.binding.vaccineNameTextView.setText(vaccineModel.getVaccineName());
        viewHolder.binding.vaccineImageView.setImageResource(vaccineModel.getVaccineImg());
    }

    @Override
    public int getItemCount() {
        return vaccineModels.length;
    }

    // Custom view holder class
    private static class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerViewItemBinding binding;

        public ViewHolder(RecyclerViewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null){
                        clickListener.onClick(view, getAdapterPosition());
                    }
                }
            });
        }
    }
}