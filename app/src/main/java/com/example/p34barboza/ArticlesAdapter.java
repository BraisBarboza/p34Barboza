package com.example.p34barboza;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.MyViewHolder> {
    private ArrayList<Article> mDataset;
    public interface OnItemClickListener {
        public void onClick(View view, int position);
    }
    private static OnItemClickListener clickListener;
    public void setClickListener(OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title, subtitle;
        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title_title_tv);
            subtitle= view.findViewById(R.id.title_subtitle_tv);
            view.setOnClickListener(this);
        }
        public void bind(Article article) {
            title.setText(article.getTitle());
            subtitle.setText(article.getSubtitle());
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
    public ArticlesAdapter(ArrayList<Article> myDataset) {
        mDataset = myDataset;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_tile, parent, false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(mDataset.get(position));
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
    public void removeAll(){
        int size= mDataset.size();
        mDataset.removeAll(mDataset);
        notifyItemRangeRemoved(0,size);
    }
    public void insertItem(Article article){
        mDataset.add(article);
        notifyItemInserted(mDataset.size()-1);
    }
    public void setItems(ArrayList<Article> articles){
        mDataset.addAll(articles);
    }
    public void deleteItem(Article article){
        mDataset.remove(article);
    }
}