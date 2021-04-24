package com.example.youtaskk;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class TugasRepository {

    private TugasDao mTugasDao;
    private LiveData<List<Tugas>> mAllTugas;


    TugasRepository(Application application){
        TugasRoomDatabase db = TugasRoomDatabase.getDatabase(application);
        mTugasDao = db.tugasDao();
        mAllTugas = mTugasDao.getAlphabetizedWords();
    }

    LiveData<List<Tugas>> getAllTugas(){
        return mAllTugas;
    }

    void insert(Tugas tugas){
        TugasRoomDatabase.databaseWriteExecutor.execute(() ->{
            mTugasDao.insert(tugas);
        });
    }

}