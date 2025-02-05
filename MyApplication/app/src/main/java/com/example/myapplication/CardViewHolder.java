package com.example.myapplication;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, PopupMenu.OnMenuItemClickListener{

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

        view.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_opciones, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        int itemId = item.getItemId();



        return false;
    }

}
