package com.example.msslabtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {
    int flagCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
    }

    public void addStudent(View view) {
        Cursor mListStudent;
        EditText editTextStudentName = (EditText) findViewById(R.id.editTextStudentName);
        EditText editTextStudentScore = (EditText) findViewById(R.id.editTextStudentScore);

        if (((editTextStudentName != null) && (editTextStudentName.length() > 0)) &&
            ((editTextStudentScore != null) && (editTextStudentScore.length() > 0))) {
            String studentName = editTextStudentName.getText().toString().trim();
            String studentScore = editTextStudentScore.getText().toString().trim();
            hideSoftKeyboard();

            mListStudent = getContentResolver().query(Uri.parse("content://com.example.msslabfour.provider/student"), null, null, null);
            if (mListStudent.moveToFirst()) {
                while (!mListStudent.isAfterLast()) {
                    if (mListStudent.getString(mListStudent.getColumnIndexOrThrow("name")).equals(studentName)
                        && Double.toString(mListStudent.getDouble(mListStudent.getColumnIndexOrThrow("score"))).equals(studentScore)) {
                        flagCount++;
                    }
                    mListStudent.moveToNext();
                }
            }
            mListStudent.close();

            if (flagCount == 0){
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", studentName);
                contentValues.put("score", studentScore);
                getContentResolver().insert(Uri.parse("content://com.example.msslabfour.provider/student"), contentValues);

                Toast.makeText(this, "Student ("
                        + studentName + ", " + studentScore
                        + ") is added!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Student information existed!", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Please check again student information!", Toast.LENGTH_SHORT).show();
        }
    }

    public void hideSoftKeyboard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}