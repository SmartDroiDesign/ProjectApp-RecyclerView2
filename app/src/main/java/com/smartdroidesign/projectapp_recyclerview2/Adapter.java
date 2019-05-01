package com.smartdroidesign.projectapp_recyclerview2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder>{

    private static final String TAG = "Adapter";
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    private ArrayList<Items> mItems;
    private ArrayList<String> mImages;
    private Context mContext;
    private RecyclerView mRecyclerView;



    public Adapter(Context context, ArrayList<Items> items, ArrayList<String> images) {
        mItems = items;
        mContext = context;
        mImages = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view, mListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Items currentItem = mItems.get(position);
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.lineOne.setText(currentItem.getTextOne());
        holder.lineTwo.setText(currentItem.getTextTwo());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }



}
