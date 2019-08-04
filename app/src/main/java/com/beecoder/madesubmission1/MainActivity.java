package com.beecoder.madesubmission1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] movieName;
    private String[] movieRelease;
    private String[] movieDescription;
    private TypedArray moviePhoto;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieAdapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(movieAdapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = new Movie();
                movie.setPhoto(moviePhoto.getResourceId(position, -1));
                movie.setName(movieName[position]);
                movie.setRelease(movieRelease[position]);
                movie.setDescription(movieDescription[position]);

                Intent sendDataToDetailActivity = new Intent(MainActivity.this, DetailActivity.class);
                sendDataToDetailActivity.putExtra(DetailActivity.EXTRA_MOVIE, movie);
                startActivity(sendDataToDetailActivity);
            }
        });
    }

    private void prepare(){
        movieName = getResources().getStringArray(R.array.movie_name);
        movieRelease = getResources().getStringArray(R.array.movie_release);
        movieDescription = getResources().getStringArray(R.array.movie_description);
        moviePhoto = getResources().obtainTypedArray(R.array.movie_photo);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < movieName.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(moviePhoto.getResourceId(i, -1));
            movie.setName(movieName[i]);
            movie.setRelease(movieRelease[i]);
            movies.add(movie);
        }
        movieAdapter.setMovies(movies);
    }
}
