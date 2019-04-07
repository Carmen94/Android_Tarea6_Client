package com.iteso.android_tarea6_client;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.android_tarea6_client.tools.Constants;

public class ActivityStore extends AppCompatActivity {
    private static final String PROVIDER_NAME = "com.iteso.android_tarea6.tools.store";
    private static final String BASE_PATH ="store";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/" + BASE_PATH );
    TextView storeName;
    TextView storeLat;
    TextView storeLon;
    TextView storePhone;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        storeName = findViewById(R.id.store_name);
        storeLat = findViewById(R.id.store_lat);
        storeLon = findViewById(R.id.store_lon);
        storePhone = findViewById(R.id.store_phone);
        save = findViewById(R.id.saveStore);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver contentResolver = getContentResolver();
                ContentValues values = new ContentValues();
                values.put(Constants.KEY_STORE_NAME, storeName.getText().toString());
                values.put(Constants.KEY_STORE_LAT, Double.parseDouble(storeLat.getText().toString()));
                values.put(Constants.KEY_STORE_LNG, Double.parseDouble(storeLon.getText().toString()));
                values.put(Constants.KEY_STORE_PHONE, storePhone.getText().toString());
                values.put(Constants.KEY_STORE_THUMBNAIL, 0);
                values.put(Constants.KEY_CITY_ID,1);
                Uri uri = contentResolver.insert(CONTENT_URI, values);
                if(uri!=null){
                    Toast.makeText(v.getContext(),R.string.add_store_toast,Toast.LENGTH_LONG).show();
                }
                finish();
            }
        });
    }
}
