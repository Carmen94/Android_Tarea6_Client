package com.iteso.android_tarea6_client;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.iteso.android_tarea6_client.beans.ItemProduct;
import com.iteso.android_tarea6_client.tools.AdapterProduct;
import com.iteso.android_tarea6_client.tools.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<ItemProduct> products;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int selectedCategory=1;
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
        fetchProducts();
        mAdapter = new AdapterProduct(this, products);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.technology_menu) {
           refreshProducts(Constants.CATEGORY_TECH);
            return true;
        } else if (id == R.id.home_menu){
            refreshProducts(Constants.CATEGORY_HOME);
            return true;
        }else if(id==R.id.electronics_menu){
            refreshProducts(Constants.CATEGORY_ELECTRONICS);
        }else {
            Intent intent = new Intent(this,ActivityStore.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void fetchProducts(){
        ContentResolver contentResolver = getContentResolver();
        Uri uri = CONTENT_URI;
        products=new ArrayList<>();
        String  whereClause = "idCategory = " + selectedCategory;
        Cursor cursor = contentResolver.query(uri,null, whereClause, null, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ItemProduct newItem = new ItemProduct();
                newItem.setCode(cursor.getInt(cursor.getColumnIndex(Constants.KEY_PRODUCT_ID)));
                newItem.setTitle(cursor.getString(cursor.getColumnIndex(Constants.KEY_PRODUCT_TITLE)));
                newItem.setDescription(cursor.getString(cursor.getColumnIndex(Constants.KEY_PRODUCT_DESCRIPTION)));
                products.add(newItem);
                cursor.moveToNext();
            }
        }
    }

    private void refreshProducts(int selectedCategory){
        this.selectedCategory=selectedCategory;
        ContentResolver contentResolver = getContentResolver();
        Uri uri = CONTENT_URI;
        products.clear();
        String  whereClause = "idCategory = " + this.selectedCategory;
        Cursor cursor = contentResolver.query(uri,null, whereClause, null, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ItemProduct newItem = new ItemProduct();
                newItem.setCode(cursor.getInt(cursor.getColumnIndex(Constants.KEY_PRODUCT_ID)));
                newItem.setTitle(cursor.getString(cursor.getColumnIndex(Constants.KEY_PRODUCT_TITLE)));
                newItem.setDescription(cursor.getString(cursor.getColumnIndex(Constants.KEY_PRODUCT_DESCRIPTION)));
                products.add(newItem);
                cursor.moveToNext();
            }
        }
        mAdapter.notifyDataSetChanged();
    }


}
