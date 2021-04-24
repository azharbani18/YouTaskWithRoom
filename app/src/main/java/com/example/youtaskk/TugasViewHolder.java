package com.example.youtaskk;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TugasViewHolder extends RecyclerView.ViewHolder {

    private final TextView NamaItemView;
    private final TextView Deskripsi;
    private final TextView Deadline;
    ConstraintLayout mainLayout;

    private TugasViewHolder(View itemView){
        super(itemView);
        NamaItemView = itemView.findViewById(R.id.title);
        Deadline = itemView.findViewById(R.id.tanggal);
        Deskripsi = itemView.findViewById(R.id.deskripsi);
        mainLayout = itemView.findViewById(R.id.mainLayout);
    }

    public void bind(String nama, String deadline,  String deskripsi){
        NamaItemView.setText(nama);
        Deadline.setText(deadline);
        //Deskripsi.setText(deskripsi);
    }

    static TugasViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_row,parent,false);
        return new TugasViewHolder(view);
    }

}