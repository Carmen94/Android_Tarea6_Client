package com.iteso.android_tarea6_client;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iteso.android_tarea6_client.beans.ItemProduct;
import com.iteso.android_tarea6_client.tools.AdapterProduct;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<ItemProduct> products;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String PROVIDER_NAME = "com.iteso.android_tarea6.tools.product";
    private static final String BASE_PATH ="product";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/" + BASE_PATH );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.main_recycle_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        products = new ArrayList<>();
        ContentResolver contentResolver = getContentResolver();
        Uri uri = CONTENT_URI;
        String  whereClause = "idCategory = " + 1;
        Cursor cursor = contentResolver.query(uri,null, whereClause, null, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ItemProduct newItem = new ItemProduct();
                newItem.setCode(cursor.getInt(0));
                newItem.setTitle(cursor.getString(1));
                products.add(newItem);
                cursor.moveToNext();
            }
        }
        mAdapter = new AdapterProduct(this, products);
        recyclerView.setAdapter(mAdapter);

    }
}
