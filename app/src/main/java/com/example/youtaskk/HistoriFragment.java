package com.example.youtaskk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HistoriFragment extends Fragment {

    String[] s1;
    String[] s2;
//    String[] s3;
    RecyclerView recyclerview;

    public HistoriFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        s1 = getResources().getStringArray(R.array.list_tugas_selesai);
//        s2 = getResources().getStringArray(R.array.deskripsi_selesai);
        s2 = getResources().getStringArray(R.array.tanggal_selesai);
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        tugasAdapter myAdapter = new tugasAdapter(getContext(), s1,s2);
        recyclerview = view.findViewById(R.id.recyclerViewHistory);
        recyclerview.setAdapter(myAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}