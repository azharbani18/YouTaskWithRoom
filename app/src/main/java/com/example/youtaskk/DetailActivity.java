package com.example.youtaskk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {


    TextView s1,s2,s3;

    String data1,data2,data3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        s1 = findViewById(R.id.myTextTugas);
        s3 = findViewById(R.id.myTextDeadline);
        s2 = findViewById(R.id.myTextCatatan);

        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("data3")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
        }else {
            Toast.makeText(this,"Nothing",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        s1.setText(data1);
        s2.setText(data2);
        s3.setText(data3);
    }
}