package com.example.task51;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationFragment extends Fragment {

    private Image image;
    private String desc;
    private String title;

    ImageView imageView;
    TextView TitleTextView;
    TextView DescTextView;

    public LocationFragment(Image image, String desc, String title) {
        this.image = image;
        this.desc = desc;
        this.title = title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        imageView = findViewById(R.id.Ima);
        return inflater.inflate(R.layout.fragment_location, container, false);
    }
}