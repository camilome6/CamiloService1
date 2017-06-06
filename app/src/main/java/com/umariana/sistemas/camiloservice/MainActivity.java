package com.umariana.sistemas.camiloservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.umariana.sistemas.camiloservice.Models.Adaptador;
import com.umariana.sistemas.camiloservice.Models.Presidentes;
import com.umariana.sistemas.camiloservice.OpenService.DatosColombia;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private static final String TAG = "PRESIDENTES";
    private RecyclerView recyclerView;
    private boolean aptoParaCargar;
    private Adaptador Adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Adaptador = new Adaptador(this);
        recyclerView.setAdapter(Adaptador);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            obtenerListaPresidentes();
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar = true;
        obtenerListaPresidentes();
    }

    private void obtenerListaPresidentes() {

        DatosColombia service = retrofit.create(DatosColombia.class);
        Call<ArrayList<Presidentes>> presidentesRespuestaCall = service.obtenerListaPresidentes();

        presidentesRespuestaCall.enqueue(new Callback<ArrayList<Presidentes>>() {
            @Override
            public void onResponse(Call<ArrayList<Presidentes>> call, Response<ArrayList<Presidentes>> response) {
                if(response.isSuccessful()){
                    ArrayList lista = response.body();
                    Adaptador.ListaPresidentes(lista);
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Presidentes>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });

    }

    public  void acerca(View view)
    {
        Intent i = new Intent(this, acerca.class );
        startActivity(i);
    }




}

