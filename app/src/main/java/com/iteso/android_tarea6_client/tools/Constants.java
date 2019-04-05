package com.iteso.android_tarea6_client.tools;

public class Constants {
    public final static String DATABASE_NAME = "ITESO_STORE";
    public final static int DATABASE_VERSION = 1;
    //Tables
    public static final String TABLE_STORE = "store";
    public static final String TABLE_PRODUCT = "product";
    public static final String TABLE_CITY = "city";
    public static final String TABLE_CATEGORY = "category";
    public static final String TABLE_STORE_PRODUCT = "storeProduct";
    // Store
    public static final String KEY_STORE_ID = "idStore";
    public static final String KEY_STORE_NAME = "storeName";
    public static final String KEY_STORE_PHONE = "phone";
    public static final String KEY_STORE_CITY = "idCity";
    public static final String KEY_STORE_THUMBNAIL = "thumbnail";
    public static final String KEY_STORE_LAT = "latitude";
    public static final String KEY_STORE_LNG = "longitude";
    // Columns Cities
    public static final String KEY_CITY_ID = "idCity";
    public static final String KEY_CITY_NAME = "cityName";
    // Columns Category
    public static final String KEY_CATEGORY_ID = "idCategory";
    public static final String KEY_CATEGORY_NAME = "categoryName";
    // Columns Products
    public static final String KEY_PRODUCT_ID = "idProduct";
    public static final String KEY_PRODUCT_TITLE = "productName";
    public static final String KEY_PRODUCT_IMAGE = "image";
    public static final String KEY_PRODUCT_CATEGORY = "idCategory";
    public static final String KEY_PRODUCT_DESCRIPTION = "description";
    // Columns StoreProduct
    public static final String KEY_STORE_PRODUCT_ID = "idStoreProduct";
    public static final String KEY_STORE_PRODUCT_P_ID = "idProduct";
    public static final String KEY_STORE_PRODUCT_S_ID = "idStore";

    public static final int CATEGORY_TECH = 1;
    public static final int CATEGORY_HOME = 2;
    public static final int CATEGORY_ELECTRONICS = 3;

}
