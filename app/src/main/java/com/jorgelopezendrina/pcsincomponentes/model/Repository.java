package com.jorgelopezendrina.pcsincomponentes.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.jorgelopezendrina.pcsincomponentes.model.client.InformaticoClient;
import com.jorgelopezendrina.pcsincomponentes.model.client.OrdenadorClient;
import com.jorgelopezendrina.pcsincomponentes.model.pojo.Informatico;
import com.jorgelopezendrina.pcsincomponentes.model.pojo.Ordenador;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private Retrofit retrofit;
    private InformaticoClient informaticoClient;
    private OrdenadorClient ordenadorClient;
    private Context context;

    public Repository(Context context) {
        String url ="https://informatica.ieszaidinvergeles.org:9031/LaravelsProyect/tiendaOrdenadores/public/api/";
        retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        this.context = context;
    }

    /*-----------------------------------------INFORMÁTICO----------------------------------------*/

    public void  borrarInformatico(long id){
        informaticoClient = retrofit.create(InformaticoClient.class);
        Call<Integer> request =informaticoClient.deleteInformatico(id);
        request.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Toast.makeText(context, "Informático Borrado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(context, "Se ha producido un fallo. Datos no borrados", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void devuelveInformatico(long id){
        informaticoClient = retrofit.create(InformaticoClient.class);
        Call<Informatico> request = informaticoClient.getInformatico(id);
        request.enqueue(new Callback<Informatico>() {
            @Override
            public void onResponse(Call<Informatico> call, Response<Informatico> response) {
                Toast.makeText(context, "Se ha devuelto un informático", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Informatico> call, Throwable t) {
                Toast.makeText(context, "Se ha producido un fallo. Informático no devueltos", Toast.LENGTH_LONG).show();
            }
        });
    }

    public MutableLiveData<List<Informatico>> devuelveListaInformaticos(){
        informaticoClient = retrofit.create(InformaticoClient.class);
        MutableLiveData<List<Informatico>> liveDataInformaticos = new MutableLiveData<>();
        Call<List<Informatico>> request = informaticoClient.getListaInformaticos();
        request.enqueue(new Callback<List<Informatico>>() {
            @Override
            public void onResponse(Call<List<Informatico>> call, Response<List<Informatico>> response) {
                liveDataInformaticos.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Informatico>> call, Throwable t) {
                Toast.makeText(context, "Se ha producido un error", Toast.LENGTH_LONG).show();
            }
        });

        return liveDataInformaticos;
    }

    public void insertaInformatico(Informatico informatico){
        informaticoClient = retrofit.create(InformaticoClient.class);
        Call<Long> request = informaticoClient.insertInformatico(informatico);
        request.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Toast.makeText(context, "Informático insertado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Toast.makeText(context, "Se ha producido un fallo. Datos no incluidos", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void actualizaInformatico(long id, Informatico informatico){
        informaticoClient = retrofit.create(InformaticoClient.class);
        Call<Boolean> request = informaticoClient.updateInformatico(id, informatico);
        request.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Toast.makeText(context, "Informático actualizado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(context, "Se ha producido un fallo. Datos no actualizados", Toast.LENGTH_LONG).show();
            }
        });
    }

    /*------------------------------------------ORDENADOR-----------------------------------------*/
    public void  borrarOrdenador(long id){
        ordenadorClient = retrofit.create(OrdenadorClient.class);
        Call<Integer> request = ordenadorClient.deleteOrdenador(id);
        request.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Toast.makeText(context, "Ordenador Borrado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(context, "Se ha producido un fallo. Datos no borrados", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void devuelveOrdenador(long id){
        ordenadorClient = retrofit.create(OrdenadorClient.class);
        Call<Ordenador> request = ordenadorClient.getOrdenador(id);
        request.enqueue(new Callback<Ordenador>() {
            @Override
            public void onResponse(Call<Ordenador> call, Response<Ordenador> response) {
                Toast.makeText(context, "Se ha devuelto un ordenador", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Ordenador> call, Throwable t) {
                Toast.makeText(context, "Se ha producido un fallo. Datos no borrados", Toast.LENGTH_LONG).show();
            }
        });
    }

    public MutableLiveData<List<Ordenador>>  devuelveListaOrdenador(){
        ordenadorClient = retrofit.create(OrdenadorClient.class);
        MutableLiveData<List<Ordenador>> liveDataOrdenadores = new MutableLiveData<>();
        Call<List<Ordenador>> request = ordenadorClient.getListaOrdenadores();
        request.enqueue(new Callback<List<Ordenador>>() {
            @Override
            public void onResponse(Call<List<Ordenador>> call, Response<List<Ordenador>> response) {
                liveDataOrdenadores.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Ordenador>> call, Throwable t) {
                Toast.makeText(context, "Se ha producido un error", Toast.LENGTH_LONG).show();
            }
        });

        return  liveDataOrdenadores;
    }

    public void insertaOrdenador(Ordenador ordenador){
        ordenadorClient = retrofit.create(OrdenadorClient.class);
        Call<Long> request = ordenadorClient.insertOrdenador(ordenador);
        request.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Toast.makeText(context, "Ordenador insertado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Toast.makeText(context, "Se ha producido un fallo. Datos no incluidos", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void actualizaOrdenador(long id, Ordenador ordenador){
        ordenadorClient = retrofit.create(OrdenadorClient.class);
        Call<Boolean> request = ordenadorClient.updateOrdenador(id, ordenador);
        request.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Toast.makeText(context, "Ordenador actualizado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(context, "Se ha producido un fallo. Datos no borrados", Toast.LENGTH_LONG).show();
            }
        });
    }
}
