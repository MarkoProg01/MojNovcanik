package com.example.mojnovcanik.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mojnovcanik.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class SettingsRecyclerAdapter extends RecyclerView.Adapter<SettingsRecyclerAdapter.ViewHolder> {

    String[] optionsName = {"Change language","Change background color","Report problem","Change valute"};
    String[] optionsDescription = {"Select the language you want to use","Select the color of the application","Report a problem in the application\nto the developers","Choose the currency you want to use"};
    Integer[] optionsIcon = {R.drawable.ic_language,R.drawable.ic_color,R.drawable.ic_report,R.drawable.ic_valute};


    @Override
    public SettingsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.settings_recycler_design,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SettingsRecyclerAdapter.ViewHolder holder, int position) {
    holder.settingsImageView.setImageResource(optionsIcon[position]);
    holder.settingsText.setText(optionsName[position]);
    holder.settingsSubText.setText(optionsDescription[position]);
    }

    @Override
    public int getItemCount() {
        return optionsName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView settingsText,settingsSubText;
        ImageView settingsImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            settingsText = itemView.findViewById(R.id.settingsText);
            settingsSubText = itemView.findViewById(R.id.settingsSubText);
            settingsImageView = itemView.findViewById(R.id.settingsImageView);

        }
    }
}
