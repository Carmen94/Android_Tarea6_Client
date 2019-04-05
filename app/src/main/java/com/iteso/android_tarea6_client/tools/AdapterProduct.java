package com.iteso.android_tarea6_client.tools;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.android_tarea6_client.R;
import com.iteso.android_tarea6_client.beans.ItemProduct;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {
    private ArrayList<ItemProduct> mDataSet;
    private Context context;

    private static final String PROVIDER_NAME = "com.iteso.android_tarea6.tools.product";
    private static final String BASE_PATH ="products";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/" + BASE_PATH );

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
        public TextView mProductStore;
        public TextView mProductLocation;
        public TextView mProductPhone;

        public Context context;

        public ViewHolder(View v) {
            super(v);
            context = v.getContext();
            mProductTitle = (TextView) v.findViewById(R.id.item_product_title);
            mProductStore = (TextView) v.findViewById(R.id.item_product_store);
            mProductLocation = (TextView) v.findViewById(R.id.item_product_location);
            mProductPhone = (TextView) v.findViewById(R.id.item_product_phone);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mProductTitle.setText(mDataSet.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}