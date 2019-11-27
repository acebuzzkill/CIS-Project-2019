package com.example.claremountconnection.Opportunities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.claremountconnection.R;

import java.util.ArrayList;

public class OpportunitiesAdapter extends RecyclerView.Adapter<com.example.claremountconnection.Opportunities.OpportunitiesAdapter.ExampleViewHolder> {
    private ArrayList<OpportunitiesGetText> mExampleList;
    private com.example.claremountconnection.Opportunities.OpportunitiesAdapter.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(com.example.claremountconnection.Opportunities.OpportunitiesAdapter.OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        //public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ImageView mDeleteImage;

        public ExampleViewHolder(View itemView, final com.example.claremountconnection.Opportunities.OpportunitiesAdapter.OnItemClickListener listener) {
            super(itemView);
            //mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mDeleteImage = itemView.findViewById(R.id.image_delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public OpportunitiesAdapter(ArrayList<OpportunitiesGetText> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public com.example.claremountconnection.Opportunities.OpportunitiesAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_hard_code_message_text, parent, false);
        com.example.claremountconnection.Opportunities.OpportunitiesAdapter.ExampleViewHolder evh = new com.example.claremountconnection.Opportunities.OpportunitiesAdapter.ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(com.example.claremountconnection.Opportunities.OpportunitiesAdapter.ExampleViewHolder holder, int position) {
        OpportunitiesGetText currentItem = mExampleList.get(position);

        //holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}