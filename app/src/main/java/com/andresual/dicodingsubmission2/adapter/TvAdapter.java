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
import com.andresual.dicodingsubmission2.model.TvModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ListViewHolder> {

    private ArrayList<TvModel> tvModelArrayList;
    Context context;

    public TvAdapter(Context context, ArrayList<TvModel> tvModelArrayList) {
        this.tvModelArrayList = tvModelArrayList;
        this.context = context;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDesc;
        TextView tvYear;
        ImageView ivMovie;
        CardView cvTv;

        public ListViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvYear = view.findViewById(R.id.tv_year);
            tvDesc = view.findViewById(R.id.tv_excerpt);
            ivMovie = view.findViewById(R.id.iv_hero);
            cvTv = view.findViewById(R.id.cv_item);
        }
    }

    @NonNull
    @Override
    public TvAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_tv, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.ListViewHolder holder, final int position) {
        TvModel tvModel = tvModelArrayList.get(position);

        holder.tvTitle.setText(tvModel.getTitle());
        holder.tvDesc.setText(tvModel.getDesc());
        holder.tvYear.setText(tvModel.getYear());

        Glide.with(holder.itemView.getContext())
                .load(tvModel.getImg())
                .apply(new RequestOptions())
                .into(holder.ivMovie);

        holder.cvTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieModel movieModel = new MovieModel();
                movieModel.setTitle(tvModelArrayList.get(position).getTitle());
                movieModel.setDesc(tvModelArrayList.get(position).getDesc());
                movieModel.setYear(tvModelArrayList.get(position).getYear());
                movieModel.setImg(tvModelArrayList.get(position).getImg());
                Intent moveWithObjectIntent = new Intent(context, DetailActivity.class);
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MOVIE, movieModel);
                context.startActivity(moveWithObjectIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tvModelArrayList.size();
    }
}
