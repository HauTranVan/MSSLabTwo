package com.example.msslabtwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListStudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("Scarlet Witch", 8.5));
        studentList.add(new Student("Thor", 7.9));
        studentList.add(new Student("Doctor Strange", 6.4));
        studentList.add(new Student("Black Panther", 9.2));
        studentList.add(new Student("Captain Marvel", 7.5));
        studentList.add(new Student("Hulk", 8.6));
        studentList.add(new Student("Captain America", 8.0));
        studentList.add(new Student("Spider Man", 6.5));
        studentList.add(new Student("Iron Man", 8.9));
        studentList.add(new Student("Star Lord", 7.2));
        studentList.add(new Student("Vision", 6.8));
        studentList.add(new Student("Ant Man", 8.4));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new StudentAdapter(getApplicationContext(), studentList));
    }
}