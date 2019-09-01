package com.andresual.dicodingsubmission2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.andresual.dicodingsubmission2.R;
import com.andresual.dicodingsubmission2.model.MovieModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class DetailActivity extends AppCompatActivity {

    TextView tvDesc;
    ImageView ivMovie;

    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsing;
    Toolbar toolbar;

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        appBarLayout = findViewById(R.id.app_bar_layout);
        collapsing = findViewById(R.id.collapsing);
        toolbar = findViewById(R.id.toolbar);
        tvDesc = findViewById(R.id.tv_desc);
        ivMovie = findViewById(R.id.img_movie);

        MovieModel movieModel = getIntent().getParcelableExtra(EXTRA_MOVIE);
        collapsing.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsing.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsing.setTitle(movieModel.getTitle() + " " + movieModel.getYear());
        tvDesc.setText(movieModel.getDesc());
        ivMovie.setImageResource(movieModel.getImg());


    }
}
