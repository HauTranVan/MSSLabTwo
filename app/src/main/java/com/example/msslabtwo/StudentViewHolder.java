package com.example.msslabtwo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    TextView nameView, scoreView;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.studentName);
        scoreView = itemView.findViewById(R.id.studentScore);
    }
}
