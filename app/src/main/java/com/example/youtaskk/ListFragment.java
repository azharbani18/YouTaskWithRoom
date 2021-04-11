package com.example.youtaskk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ListFragment extends Fragment {

    String[] s1;
    String[] s2;
//    String[] s3;
    RecyclerView recyclerview;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        s1 = getResources().getStringArray(R.array.list_tugas);
//        s2 = getResources().getStringArray(R.array.deskripsi);
        s2 = getResources().getStringArray(R.array.tanggal);
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        tugasAdapter myAdapter = new tugasAdapter(getContext(), s1,s2);
        recyclerview = view.findViewById(R.id.recyclerView);
        recyclerview.setAdapter(myAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}