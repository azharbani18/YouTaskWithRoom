package com.example.youtaskk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {


    TextView s1,s2,s3;

    String data1,data2,data3;
    ImageView imageView;
    private TugasViewModel mTugasViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        s1 = findViewById(R.id.myTextTugas);
        s3 = findViewById(R.id.myTextDeadline);
        s2 = findViewById(R.id.myTextCatatan);

        getData();
        setData();
//        findViewById(R.id.ic).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

//        findViewById(R.id.HapusButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mTugasViewModel = new ViewModelProvider(DetailActivity.this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(TugasViewModel.class);

//            }
//        });

    }

    private void getData(){
        if(getIntent().hasExtra("tugas") && getIntent().hasExtra("catatan") ){
            data1 = getIntent().getStringExtra("tugas");
            data2 = getIntent().getStringExtra("deadline");
            data3 = getIntent().getStringExtra("catatan");
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