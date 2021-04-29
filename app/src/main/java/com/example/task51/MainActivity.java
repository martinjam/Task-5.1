package com.example.task51;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DestinationAdapter.OnRowClickListener, PlacesAdapter.OnRowClickListener {
    RecyclerView DestinationsRecyclerView;
    RecyclerView PlacesRecyclerView;

    DestinationAdapter destinationAdapter;
    PlacesAdapter placesAdapter;

    List<Destination> destinationList = new ArrayList<>();
    List<Places> placesList = new ArrayList<>();

    Integer[] DestImageList = {R.drawable.antarticajpg, R.drawable.australia, R.drawable.egypt, R.drawable.miami};
    Integer[] PlacesImageList = {R.drawable.cafe, R.drawable.casino, R.drawable.cat_cafe, R.drawable.cove, R.drawable.night_club};

    String[] destNameList = {"Antartica", "Australia", "Egypt", "Miami"};
    String[] destDescList = {"Very cold here, bring a jacket and perhaps some gloves.", "We speak English, not than anyone can understand us.", "VERY hot, bring a hat and if you're feeling thrify, some sunblock.", "You will run out of money in about 9 seconds here, EXPENSIVE."};

    String[] placesNameList = {"Cafe", "Casino", "Cat Cafe", "Cove", "Night Club"};
    String[] placesDescList = {"A cute quaint little spot, a single boiled egg costs $12.", "Spend all your money for the cheap thrills that rolling dice alone in your garage just can't replicate.", "MEOW MEOW MEOW MEOW MEOW MEOW MEOW MEOW MEOW MEOW MEOW purr", "There's a mystery afoot in this Cove gang, lets split up and look for clues!", "You will find at least 9 types of illicit substances here, come for a good time, stay because you got drunk."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DestinationsRecyclerView = findViewById(R.id.DestinationsRecyclerView);
        PlacesRecyclerView = findViewById(R.id.PlacesRecyclerView);

        destinationAdapter = new DestinationAdapter(destinationList, MainActivity.this, this);
        placesAdapter = new PlacesAdapter(placesList, MainActivity.this, this);

        DestinationsRecyclerView.setAdapter(destinationAdapter);
        PlacesRecyclerView.setAdapter(placesAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        DestinationsRecyclerView.setLayoutManager(layoutManager);
        PlacesRecyclerView.setLayoutManager(layoutManager2);

        for (int i = 0; i < DestImageList.length; i++) {

            Destination destination = new Destination(i, DestImageList[i], destNameList[i], destDescList[i]);
            destinationList.add(destination);
        }

        for (int j = 0; j < PlacesImageList.length; j++) {

            Places place = new Places(j, PlacesImageList[j], placesNameList[j], placesDescList[j]);
            placesList.add(place);
        }
    }

    @Override
    public void onItemClick(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new destAntarticaFragment();
                break;
            case 1:
                Toast.makeText(this, "You clicked on South Bank ", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "You clicked on So2k ", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "You clicked on So2k ", Toast.LENGTH_SHORT).show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment ).commit();
    }

    @Override
    public void onItemClick2(int position) {
        switch (position) {
            case 0:
                Toast.makeText(this, "You clicked on Station St.", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "You clicked on South Bank ", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "You clicked on 3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "You clicked on4 ", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this, "You clicked on4 ", Toast.LENGTH_SHORT).show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }
}