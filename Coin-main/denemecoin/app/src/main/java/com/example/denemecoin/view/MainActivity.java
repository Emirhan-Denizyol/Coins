package com.example.denemecoin.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.denemecoin.R;
import com.example.denemecoin.goruntuadaptörü;
import com.example.denemecoin.model.coinmodel;
import com.example.denemecoin.service.criptointerface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    Dialog customdialogshow;
    Button button;
    Button satınal;
    TextView isim;
    TextView fiyat;
    TextView fiyatdeğişim;
    TextView hacim;
    TextView hacimdeğişim;
    EditText miktar;
    ImageView kapat;


















    ArrayList<coinmodel>coinmodels;
    private String BASE_URl="https://api.nomics.com/v1/";
    Retrofit retrofit;
    goruntuadaptörü Goruntuadaptörü;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Gson gson=new GsonBuilder().setLenient().create();
        recyclerView=findViewById(R.id.recyclerView);

        //https://api.nomics.com/v1/currencies/ticker?key=6d3a585cd39be04fc93f410287b0ef2835df9596

        retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loaddata();
    }

    private void loaddata(){

        criptointerface criptoapi=retrofit.create(criptointerface.class);
        Call<List<coinmodel>> call=criptoapi.getData();

        call.enqueue(new Callback<List<coinmodel>>() {
            @Override
            public void onResponse(Call<List<coinmodel>> call, Response<List<coinmodel>> response) {

                if(response.isSuccessful()){
                    List<coinmodel>responselist=response.body();
                    coinmodels=new ArrayList<>(responselist);
                    //goruntuadapter
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    Goruntuadaptörü=new goruntuadaptörü(coinmodels);
                    recyclerView.setAdapter(Goruntuadaptörü);




                    for (coinmodel coinmodelü:coinmodels){

                        try {

                            System.out.println(coinmodelü.currency);
                            System.out.println(("deger"+coinmodelü.price));


                        }catch (Exception e){
                            e.printStackTrace();
                            System.out.println(e);
                        }


                    }





                }

            }



            @Override
            public void onFailure(Call<List<coinmodel>> call, Throwable t) {

                System.out.println(t.toString());

            }
        });






    }




}