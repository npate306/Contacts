package com.example.neelpatel.contacts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Neel Patel on 9/27/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{

    private ArrayList<Main> mains;
    private int rowLayout;
    private Context context;

    public static class MainViewHolder extends RecyclerView.ViewHolder{
        TextView text1;
        TextView text2;

        public MainViewHolder(View v) {
            super(v);
            text1 = (TextView) v.findViewById(R.id.text2);
            text2 = (TextView) v.findViewById(R.id.text2);
        }
    }

    public MainAdapter(ArrayList<Main> mains, int rowLayout, Context context) {
        this.mains = mains;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MainViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        holder.text1.setText(mains.get(position).getName());
        holder.text2.setText(mains.get(position).getCompanyName());
    }

    @Override
    public int getItemCount() {
        return mains.size();
    }


}
