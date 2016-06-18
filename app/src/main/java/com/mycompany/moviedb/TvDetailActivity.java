package com.mycompany.moviedb;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mycompany.moviedb.Model.Tv;
import com.mycompany.moviedb.YoutubeFragment.YouTubeTvFragment;

public class TvDetailActivity extends AppCompatActivity {

    TextView genre, overview, rate, moviename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        genre = (TextView) findViewById(R.id.genre);
        overview = (TextView) findViewById(R.id.overview);
        rate = (TextView) findViewById(R.id.starRate);
        moviename = (TextView) findViewById(R.id.movieName);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Intent intent = getIntent();
        Tv movie = (Tv) intent.getSerializableExtra("movie object");
        int id = movie.getId();
        String movieName = movie.getName();

        Fragment fragment = new YouTubeTvFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("movieId", id);
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.fragment_frame, fragment).commit();
        setTitle(movieName + ": Trailer");

        overview.setText(movie.getOverView());
        rate.setText(String.valueOf(movie.getVoteAverage()));
        moviename.setText(movie.getName());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.serachAction);
        item.setVisible(false);
        return true;
    }

}
