package com.example.denemecoin.model;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.SerializedIr;

public class coinmodel {

    @SerializedName("currency")
   public String currency;
    @SerializedName("price")
   public String price;
    @SerializedName("logo_url")
    public String logo_url;
    @SerializedName("status")
    public String status;
    @SerializedName("price_change")
    public String price_change;
    @SerializedName("price_change_pct")
    public String price_change_pct;
    @SerializedName("volume_change")
    public String volume_change;
    @SerializedName("volume_change_pct")
    public String volume_change_pct;








}
