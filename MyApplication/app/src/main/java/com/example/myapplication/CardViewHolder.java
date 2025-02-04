package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CardViewHolder extends RecyclerView.ViewHolder {

    TextView tvName;
    TextView tvDesc;
    ImageView img;
    Switch sw;
    public CardViewHolder(View view) {
        super(view);
        tvName = view.findViewById(R.id.tvName);
        tvDesc = view.findViewById(R.id.tvDesc);
        img = view.findViewById(R.id.ivPhoto);
        sw = view.findViewById(R.id.swMarked);
    }
}
