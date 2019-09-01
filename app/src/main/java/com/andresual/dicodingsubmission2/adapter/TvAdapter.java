package com.andresual.dicodingsubmission2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andresual.dicodingsubmission2.R;
import com.andresual.dicodingsubmission2.model.TvModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ListViewHolder> {

    private ArrayList<TvModel> tvModelArrayList;

    public TvAdapter(ArrayList<TvModel> tvModelArrayList) {
        this.tvModelArrayList = tvModelArrayList;
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
    public TvAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_tv, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.ListViewHolder holder, int position) {
        TvModel tvModel = tvModelArrayList.get(position);

        holder.tvTitle.setText(tvModel.getTitle());
        holder.tvDesc.setText(tvModel.getDesc());
        holder.tvYear.setText(tvModel.getYear());

        Glide.with(holder.itemView.getContext())
                .load(tvModel.getImg())
                .apply(new RequestOptions())
                .into(holder.ivMovie);
    }

    @Override
    public int getItemCount() {
        return tvModelArrayList.size();
    }
}
