package com.example.vaccineapp;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccineapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private ActivityMainBinding binding;
    VaccineCustomAdapter adapter;

    VaccineModel[] vaccineModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Set the content view to the root view of the binding
        setContentView(binding.getRoot());

        // Create the data source
        vaccineModels = new VaccineModel[]{
                new VaccineModel("Hepatitis B Vaccine", R.drawable.vaccine1),
                new VaccineModel("Tetanus Vaccine", R.drawable.vaccine4),
                new VaccineModel("Pneumococcal Vaccine", R.drawable.vaccine5),
                new VaccineModel("Rotavirus Vaccine", R.drawable.vaccine6),
                new VaccineModel("Measles Virus", R.drawable.vaccine7),
                new VaccineModel("Cholera  Virus", R.drawable.vaccine8),
                new VaccineModel("Covid-19 Virus", R.drawable.vaccine9)
        };


        // Create the adapter
        adapter = new VaccineCustomAdapter(vaccineModels);
        binding.recylerView.setHasFixedSize(true);
        binding.recylerView.setLayoutManager(new LinearLayoutManager(this));


        // Set the adapter to the recycler view
        binding.recylerView.setAdapter(adapter);

        //handle click event
        adapter.setClickListener(this);

    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Vaccine name: "+vaccineModels[pos].getVaccineName() , Toast.LENGTH_SHORT).show();
    }
}