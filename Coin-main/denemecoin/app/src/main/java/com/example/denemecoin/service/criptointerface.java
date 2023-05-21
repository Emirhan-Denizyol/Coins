package com.example.denemecoin.service;




import com.example.denemecoin.model.coinmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface criptointerface {
   @GET("currencies/ticker?key=6d3a585cd39be04fc93f410287b0ef2835df9596")
    Call<List<coinmodel>>getData();

}
