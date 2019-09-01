package com.andresual.dicodingsubmission2.fragment;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andresual.dicodingsubmission2.R;
import com.andresual.dicodingsubmission2.adapter.MovieAdapter;
import com.andresual.dicodingsubmission2.model.MovieModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private String[] dataTitle;
    private String[] dataDesc;
    private String[] dataYear;
    private TypedArray dataImg;

    private RecyclerView rvMovie;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_movie, container, false);

        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);
        prepare();
        showRecyclerList();

        return view;
    }

    private void showRecyclerList(){

        ArrayList<MovieModel> movieModelArrayList = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            MovieModel movieModel = new MovieModel();
            movieModel.setTitle(dataTitle[i]);
            movieModel.setDesc(dataDesc[i]);
            movieModel.setYear(dataYear[i]);
            movieModel.setImg(dataImg.getResourceId(i, - 1));
            movieModelArrayList.add(movieModel);
        }

        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(movieModelArrayList);
        rvMovie.setAdapter(movieAdapter);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDesc = getResources().getStringArray(R.array.data_description);
        dataYear = getResources().getStringArray(R.array.data_year);
        dataImg = getResources().obtainTypedArray(R.array.data_photo);
    }
}
