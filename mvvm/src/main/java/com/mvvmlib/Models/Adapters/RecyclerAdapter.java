package com.mvvmlib.models.Adapters;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ObservableList<T> items;
    private int layout;

    public RecyclerAdapter(ObservableList<T> items, int layout) {
        this.items = items != null ? items : new ObservableArrayList<>();
        this.layout = layout;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleViewHolder(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindViewHolder(holder, items.get(position));
    }

    @Override
    public int getItemCount() {
        return items==null?0: items.size();
    }

    public abstract void bindViewHolder(RecyclerView.ViewHolder holder, T item);

}
