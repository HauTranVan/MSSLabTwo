package com.example.msslabtwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

public class ListStudentsActivity extends AppCompatActivity {

    private Cursor mListStudent;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mListStudent = getContentResolver().query(Uri.parse("content://com.example.msslabfour.provider/student"), null, null, null);
        studentAdapter = new StudentAdapter();
        studentAdapter.setData(getApplicationContext(), mListStudent);
        recyclerView.setAdapter(studentAdapter);
    }
}