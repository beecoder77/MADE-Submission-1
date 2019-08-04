package com.beecoder.madesubmission1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    TextView txtName, txtRelease, txtDescription;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtName = findViewById(R.id.txt_name);
        txtRelease = findViewById(R.id.txt_release);
        txtDescription = findViewById(R.id.txt_description);
        imgPhoto = findViewById(R.id.img_photo);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        txtName.setText(movie.getName());
        txtRelease.setText(movie.getRelease());
        txtDescription.setText(movie.getDescription());
        imgPhoto.setImageResource(movie.getPhoto());
    }
}
