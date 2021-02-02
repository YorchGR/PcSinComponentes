package com.jorgelopezendrina.pcsincomponentes.model.client;

import com.jorgelopezendrina.pcsincomponentes.model.pojo.Ordenador;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OrdenadorClient {

    @DELETE("ordenador/{id}")
    Call<Integer> deleteOrdenador(@Path("id") long id);

    @GET("ordenador/{id}")
    Call<Ordenador> getOrdenador(@Path("id") long id);

    @GET("ordenador")
    Call<List<Ordenador>> getListaOrdenadores();

    @POST("ordenador")
    Call<Long> insertOrdenador(@Body Ordenador ordenador);

    @PUT("ordenador/{id}")
    Call<Boolean> updateOrdenador(@Path("id") long id, @Body Ordenador ordenador);
}
