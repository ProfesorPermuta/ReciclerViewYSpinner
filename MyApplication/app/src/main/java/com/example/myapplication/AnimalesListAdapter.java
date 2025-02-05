package com.example.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalesListAdapter extends RecyclerView.Adapter {

    List<Animal> animales;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_card, parent, false);

        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CardViewHolder vh = (CardViewHolder) holder;
        Animal animal = animales.get(position);
        vh.tvName.setText(animal.getNombre());
        vh.tvDesc.setText(animal.getDescripcion());
        vh.img.setImageResource(animal.getImgResourceId());

    }

    @Override
    public int getItemCount() {
        return animales.size();
    }



    public AnimalesListAdapter(List<Animal> animales){

        this.animales = animales;

    }
}
