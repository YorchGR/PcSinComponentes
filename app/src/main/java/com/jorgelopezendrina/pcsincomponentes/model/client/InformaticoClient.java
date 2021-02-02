package com.jorgelopezendrina.pcsincomponentes.model.client;

import com.jorgelopezendrina.pcsincomponentes.model.pojo.Informatico;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface InformaticoClient {

    @DELETE("informatico/{id}")
    Call<Integer> deleteInformatico(@Path("id") long id);

    @GET("informatico/{id}")
    Call<Informatico> getInformatico(@Path("id") long id);

    @GET("informatico")
    Call<List<Informatico>> getListaInformaticos();

    @POST("informatico")
    Call<Long> insertInformatico(@Body Informatico informatico);

    @PUT("informatico/{id}")
    Call<Boolean> updateInformatico(@Path("id") long id, @Body Informatico informatico);

}
