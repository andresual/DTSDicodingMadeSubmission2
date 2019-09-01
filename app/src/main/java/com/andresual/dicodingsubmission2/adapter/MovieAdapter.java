package com.andresual.dicodingsubmission2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andresual.dicodingsubmission2.R;
import com.andresual.dicodingsubmission2.model.MovieModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {

    private ArrayList<MovieModel> movieModelArrayList;

    public MovieAdapter(ArrayList<MovieModel> movieAdapterArrayList) {
        this.movieModelArrayList = movieAdapterArrayList;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDesc;
        TextView tvYear;
        ImageView ivMovie;

        public ListViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvYear = view.findViewById(R.id.tv_year);
            tvDesc = view.findViewById(R.id.tv_excerpt);
            ivMovie = view.findViewById(R.id.iv_hero);
        }
    }

    @NonNull
    @Override
    public MovieAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ListViewHolder holder, int position) {
        MovieModel movieModel = movieModelArrayList.get(position);

        holder.tvTitle.setText(movieModel.getTitle());
        holder.tvDesc.setText(movieModel.getDesc());
        holder.tvYear.setText(movieModel.getYear());

        Glide.with(holder.itemView.getContext())
                .load(movieModel.getImg())
                .apply(new RequestOptions())
                .into(holder.ivMovie);
    }

    @Override
    public int getItemCount() {
        return movieModelArrayList.size();
    }
}
