package com.umariana.sistemas.camiloservice.OpenService;

import com.umariana.sistemas.camiloservice.Models.Presidentes;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sistemas on 5/06/17.
 */

public interface DatosColombia {


    @GET("f7r3-hfd8.json")
    Call<ArrayList<Presidentes>> obtenerListaPresidentes();
}
