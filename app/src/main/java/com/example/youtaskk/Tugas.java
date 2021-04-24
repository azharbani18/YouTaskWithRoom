package com.example.youtaskk;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_tugas")
public class Tugas {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "namatugas")
    private String namaTugas;

    @ColumnInfo(name = "deadline")
    private String deadline;

    @ColumnInfo(name = "deskripsi")
    private String deskripsi;

    public Tugas(@NonNull String namaTugas, String deadline, String deskripsi) {
        this.namaTugas = namaTugas;
        this.deadline = deadline;
        this.deskripsi = deskripsi;
    }

    public String getNamaTugas(){return this.namaTugas;}
    public String getDeadline() {return deadline;}
    public String getDeskripsi() {return deskripsi;}
}
