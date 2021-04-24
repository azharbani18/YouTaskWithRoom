package com.example.youtaskk;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListFragment extends Fragment {

    private TugasViewModel mTugasViewModel;
    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        final TugasListAdapter adapter = new TugasListAdapter(new TugasListAdapter.TugasDiff(),view.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        mTugasViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(TugasViewModel.class);
        mTugasViewModel.getAllTugas().observe(getViewLifecycleOwner(),tugases -> {
            adapter.submitList(tugases);
        });

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddNewTask.class);
                startActivityForResult(intent,1);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == -1){
            Tugas tugas = new Tugas(data.getStringExtra("tugas"),data.getStringExtra("deadline"),data.getStringExtra("catatan"));
            mTugasViewModel.insert(tugas);
            Toast.makeText(
                    getActivity().getApplicationContext(),
                    "MASUK PAK EKO",
                    Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(
                    getActivity().getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}