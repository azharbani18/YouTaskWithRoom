package com.example.youtaskk;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class TugasListAdapter extends ListAdapter<Tugas,TugasViewHolder> {
    Context context;
    public TugasListAdapter(@NonNull DiffUtil.ItemCallback<Tugas> diffCallback, Context ct){
        super(diffCallback);
        context = ct;
    }

    @Override
    public TugasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TugasViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TugasViewHolder holder, int position) {
        Tugas current = getItem(position);
        holder.bind(current.getNamaTugas(), current.getDeadline(), current.getDeskripsi());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("tugas",current.getNamaTugas());
                intent.putExtra("deadline",current.getDeadline());
                intent.putExtra("catatan",current.getDeskripsi());
                context.startActivity(intent);
            }
        });
    }

    static public class TugasDiff extends DiffUtil.ItemCallback<Tugas> {

        @Override
        public boolean areItemsTheSame(@NonNull Tugas oldItem, @NonNull Tugas newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tugas oldItem, @NonNull Tugas newItem) {
            boolean same;
            same = oldItem.getNamaTugas().equals(newItem.getNamaTugas()) && oldItem.getDeskripsi().equals(newItem.getDeskripsi()) ;
            return same;
        }
    }
}