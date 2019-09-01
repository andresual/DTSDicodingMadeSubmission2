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
import com.andresual.dicodingsubmission2.adapter.TvAdapter;
import com.andresual.dicodingsubmission2.model.TvModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private String[] dataTitle;
    private String[] dataDesc;
    private String[] dataYear;
    private TypedArray dataImg;

    private RecyclerView rvTv;

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_tv_show, container, false);

        rvTv = view.findViewById(R.id.rv_tv);
        rvTv.setHasFixedSize(true);
        prepare();
        showRecyclerList();

        return view;
    }

    private void showRecyclerList(){

        ArrayList<TvModel> tvModelArrayList = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            TvModel tvModel = new TvModel();
            tvModel.setTitle(dataTitle[i]);
            tvModel.setDesc(dataDesc[i]);
            tvModel.setYear(dataYear[i]);
            tvModel.setImg(dataImg.getResourceId(i, - 1));
            tvModelArrayList.add(tvModel);
        }

        rvTv.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvAdapter tvAdapter = new TvAdapter(getActivity(), tvModelArrayList);
        rvTv.setAdapter(tvAdapter);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_tv_title);
        dataDesc = getResources().getStringArray(R.array.data_tv_desc);
        dataYear = getResources().getStringArray(R.array.data_tv_year);
        dataImg = getResources().obtainTypedArray(R.array.data_tv_photo);
    }
}
