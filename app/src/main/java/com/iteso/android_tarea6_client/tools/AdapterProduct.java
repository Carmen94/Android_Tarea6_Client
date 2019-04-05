package com.iteso.android_tarea6_client.tools;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iteso.android_tarea6_client.R;
import com.iteso.android_tarea6_client.beans.ItemProduct;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {
    private ArrayList<ItemProduct> mDataSet;
    private Context context;

    public AdapterProduct(Context context, ArrayList<ItemProduct> myDataSet) {
        mDataSet = myDataSet;
        this.context = context;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public AdapterProduct.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mProductTitle;
        public TextView mProductId;
        public TextView mProductDescription;

        public Context context;

        public ViewHolder(View v) {
            super(v);
            context = v.getContext();
            mProductTitle = (TextView) v.findViewById(R.id.item_product_title);
            mProductId = (TextView) v.findViewById(R.id.item_product_id);
            mProductDescription = (TextView) v.findViewById(R.id.item_product_description);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mProductTitle.setText(mDataSet.get(position).getTitle());
        holder.mProductId.setText(String.valueOf(mDataSet.get(position).getCode()));
        holder.mProductDescription.setText(mDataSet.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}