package com.example.denemecoin;

import android.animation.IntArrayEvaluator;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.denemecoin.model.coinmodel;
import com.example.denemecoin.view.MainActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class goruntuadaptörü extends RecyclerView.Adapter<goruntuadaptörü.Rowholder>  {
   private ArrayList<coinmodel>coinlıst;
   MainActivity main=new MainActivity();





   public goruntuadaptörü(ArrayList<coinmodel>coinlıst){
       this.coinlıst=coinlıst;
   }
   private String [] colors={"#ca147e","#f6546a","#ff0065","#e6005b","#cc0051","#b30047","#ff1a74","#8c005b","#d8008d","#19120f"};


    @NonNull
    @Override
    public Rowholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layotu clasa bağlama
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.gorunum,parent,false);
        return new Rowholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Rowholder holder, int position) {
      holder.bind(coinlıst.get(position), colors, position);

    }

    @Override
    //kaç tane row oluşturulacak
    public int getItemCount() {
        return coinlıst.size();



    }

    public class Rowholder extends RecyclerView.ViewHolder {

       TextView textView2;
        TextView textView3;
        public ImageView imageView;
        public double alınancoin;
        public double satılancoin;
        public int eldekiparamik;
        public double kalancoin;
        public double kar;

        Button satınal;
        TextView isim2;
        TextView fiyat;
        TextView fiyatdeğişim;
        TextView durum;
        TextView hacim;
        TextView alınancoinmik;
        TextView hacimdeğişim;
        TextView eldekipara;
        TextView karmik;
        EditText miktar;
        ImageView kapat;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        Button islemekranıac;
        Button çıkıs;
        Button yatır;
        Button satıs;
        Button cuzdan;








        public Rowholder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(coinmodel coinmodels, String[]colors, Integer position){

            itemView.setBackgroundColor(Color.parseColor(colors[position % 9]));


            isim2=itemView.findViewById(R.id.isim2);
            linearLayout2=itemView.findViewById(R.id.coinekran);
            eldekipara=itemView.findViewById(R.id.eldekipara);
            karmik=itemView.findViewById(R.id.karmik);

            fiyat=itemView.findViewById(R.id.fiyat);
            alınancoinmik=itemView.findViewById(R.id.alınancoinmik);
            durum=itemView.findViewById(R.id.durum);
            hacim=itemView.findViewById(R.id.hacim);
            hacimdeğişim=itemView.findViewById(R.id.hacimdegisim);
            fiyatdeğişim=itemView.findViewById(R.id.fiyatdegisim);
            kapat=itemView.findViewById(R.id.kapat);
            linearLayout=itemView.findViewById(R.id.contacts_type);

            linearLayout.setVisibility(View.GONE);
            linearLayout3=itemView.findViewById(R.id.ıslemekranı);
            islemekranıac=itemView.findViewById(R.id.islemekranıac);
            linearLayout3.setVisibility(View.GONE);
            çıkıs=itemView.findViewById(R.id.cıkıs);
            satınal=itemView.findViewById(R.id.satınal);
            satıs=itemView.findViewById(R.id.sat);







             imageView=itemView.findViewById(R.id.resım);
            textView2=itemView.findViewById(R.id.textView2);

            textView3=itemView.findViewById(R.id.textView3);
            miktar=itemView.findViewById(R.id.miktar);
            satınal=itemView.findViewById(R.id.satınal);
            textView2.setText(coinmodels.currency);

            textView3.setText("Fiyat:"+coinmodels.price);
            isim2.setText(coinmodels.currency);
            fiyat.setText("Fiyat:"+coinmodels.price);

            try {
                Picasso.get().load(coinmodels.logo_url).placeholder(R.drawable.buttonarkaplan)
                        .error(R.drawable.buttonarkaplan)
                        .into(imageView);



            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e);
            }






            durum.setText("durum:"+coinmodels.status);
            if(coinmodels.price_change_pct==null){
                fiyatdeğişim.setText("fiyat değişimi:00");
            }else{
                fiyatdeğişim.setText("fiyat değişimi:"+coinmodels.price_change_pct);
            }

            if(coinmodels.volume_change==null){
                hacim.setText("Hacim:00");
            }else{
                hacim.setText("Hacim:"+coinmodels.volume_change);
            }

            if(coinmodels.volume_change_pct==null){
                hacimdeğişim.setText("hacim değişimi: 00");
            }else{
                hacimdeğişim.setText("hacim değişimi:"+coinmodels.volume_change_pct);
            }







            try {


            }catch (Exception e){
                e.printStackTrace();
                System.out.println("hata3"+e);
            }





            linearLayout2.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    try {



                        linearLayout.setVisibility(view.VISIBLE);
                        kapat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                linearLayout.setVisibility(View.GONE);

                            }
                        });



                        islemekranıac.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                linearLayout3.setVisibility(View.VISIBLE);
                                satınal.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String gelen=miktar.getText().toString();
                                        int gelendeger=Integer.parseInt(gelen);

                                        double test=Double.parseDouble(coinmodels.price);
                                        alınancoin=gelendeger/test;
                                        eldekiparamik= (int) (test*alınancoin);
                                        kar=gelendeger-(alınancoin*test);


                                        if(alınancoin>0){
                                            alınancoinmik.setVisibility(View.VISIBLE);
                                            alınancoinmik.setText("eldeki miktar:"+alınancoin);
                                            karmik.setVisibility(View.VISIBLE);
                                            if(kar==0){
                                                karmik.setText("kar mik:00");
                                            }else{
                                                karmik.setText("kar miktarı:"+kar);
                                            }

                                            satıs.setVisibility(View.VISIBLE);
                                            eldekipara.setVisibility(View.VISIBLE);
                                            eldekipara.setText("eldeki para"+eldekiparamik);
                                        }
                                        System.out.println("alınan"+test/gelendeger);


                                    }
                                });
                            }
                        });

                        satıs.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String gelen=miktar.getText().toString();
                                double gelendeger=Double.parseDouble(gelen);
                                double test=Double.parseDouble(coinmodels.price);
                               satılancoin= eldekiparamik-gelendeger;
                               eldekipara.setText("eldeki para"+satılancoin);
                               kalancoin=satılancoin/test;
                               alınancoinmik.setText("eldeki mik"+kalancoin);
                               if(satılancoin==0){
                                   satıs.setVisibility(View.GONE);
                                   alınancoinmik.setVisibility(View.GONE);
                                   eldekipara.setVisibility(View.GONE);
                                   karmik.setVisibility(View.GONE);

                               }
                            }
                        });







                        çıkıs.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                linearLayout3.setVisibility(View.GONE);
                            }
                        });






















                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("hata"+e);
                    }

                }
            });





            }






        }








    }


