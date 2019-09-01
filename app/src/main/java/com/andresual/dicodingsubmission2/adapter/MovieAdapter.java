package com.andresual.dicodingsubmission2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.andresual.dicodingsubmission2.R;
import com.andresual.dicodingsubmission2.activity.DetailActivity;
import com.andresual.dicodingsubmission2.model.MovieModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {

    private ArrayList<MovieModel> movieModelArrayList;
    Context context;

    public MovieAdapter(Context context, ArrayList<MovieModel> movieAdapterArrayList) {
        this.movieModelArrayList = movieAdapterArrayList;
        this.context = context;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDesc;
        TextView tvYear;
        ImageView ivMovie;
        CardView cvMovie;

        public ListViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvYear = view.findViewById(R.id.tv_year);
            tvDesc = view.findViewById(R.id.tv_excerpt);
            ivMovie = view.findViewById(R.id.iv_hero);
            cvMovie = view.findViewById(R.id.cv_item);
        }
    }

    @NonNull
    @Override
    public MovieAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapter.ListViewHolder holder, final int position) {
        MovieModel movieModel = movieModelArrayList.get(position);

        holder.tvTitle.setText(movieModel.getTitle());
        holder.tvDesc.setText(movieModel.getDesc());
        holder.tvYear.setText(movieModel.getYear());

        Glide.with(holder.itemView.getContext())
                .load(movieModel.getImg())
                .apply(new RequestOptions())
                .into(holder.ivMovie);

        holder.cvMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieModel movieModel = new MovieModel();
                movieModel.setTitle(movieModelArrayList.get(position).getTitle());
                movieModel.setDesc(movieModelArrayList.get(position).getDesc());
                movieModel.setYear(movieModelArrayList.get(position).getYear());
                movieModel.setImg(movieModelArrayList.get(position).getImg());
                Intent moveWithObjectIntent = new Intent(context, DetailActivity.class);
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MOVIE, movieModel);
                context.startActivity(moveWithObjectIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieModelArrayList.size();
    }
}
