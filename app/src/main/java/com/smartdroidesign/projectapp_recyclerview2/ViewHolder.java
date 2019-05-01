package com.smartdroidesign.projectapp_recyclerview2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public CircleImageView image;
    public TextView lineOne;
    public TextView lineTwo;
    public RelativeLayout parentLayout;

    public ViewHolder(@NonNull View itemView, final Adapter.OnItemClickListener listener) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        lineOne = itemView.findViewById(R.id.image_name);
        lineTwo = itemView.findViewById(R.id.image_author);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }
}
