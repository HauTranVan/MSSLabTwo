package com.example.msslabtwo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    Context context;
    Cursor mListStudent;

    public void setData(Context context, Cursor mListStudent) {
        this.context = context;
        this.mListStudent = mListStudent;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        String mStudentName;
        String mStudentScore;

        if (mListStudent.moveToPosition(position)) {
            mStudentName = mListStudent.getString(mListStudent.getColumnIndexOrThrow("name"));
            mStudentScore = Double.toString(mListStudent.getDouble(mListStudent.getColumnIndexOrThrow("score")));
            holder.nameView.setText(mStudentName);
            holder.scoreView.setText(mStudentScore);

            holder.itemView.setOnClickListener(v -> {
                mListStudent.moveToPosition(position);

                Toast.makeText(context, "Student ("
                        + mStudentName + ", " + mStudentScore
                        + ") is clicked!", Toast.LENGTH_SHORT).show();
            });
        }
    }

    @Override
    public int getItemCount() {
        if (mListStudent != null) {
            return mListStudent.getCount();
        }
        return 0;
    }
}