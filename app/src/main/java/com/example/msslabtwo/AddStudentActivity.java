package com.example.msslabtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
    }

    public void addStudent(View view) {
        EditText editTextStudentName = (EditText) findViewById(R.id.editTextStudentName);
        EditText editTextStudentScore = (EditText) findViewById(R.id.editTextStudentScore);

        if (((editTextStudentName != null) && (editTextStudentName.length() > 0)) &&
            ((editTextStudentScore != null) && (editTextStudentScore.length() > 0))) {
            String studentName = editTextStudentName.getText().toString();
            Double studentScore = Double.parseDouble(editTextStudentScore.getText().toString());
            Toast.makeText(this, "Student " + studentName + "(" + studentScore + ") is added", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Please input student information", Toast.LENGTH_SHORT).show();
        }
    }
}