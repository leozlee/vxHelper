package com.example.vxhelper.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vxhelper.R;

import java.util.List;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.ViewHolder> {
    private static String TAG = "CallAdapter";

    private List<String> mData;

    public CallAdapter(List<String> data) {
        this.mData = data;
        Log.d("UserViewAdapter", "----------------------------------UserViewAdapter");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.call_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.iv_userID);
        }

        public TextView getTextView() {
            return textView;
        }
    }


}
