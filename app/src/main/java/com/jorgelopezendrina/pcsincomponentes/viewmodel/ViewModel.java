package com.jorgelopezendrina.pcsincomponentes.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.jorgelopezendrina.pcsincomponentes.model.Repository;
import com.jorgelopezendrina.pcsincomponentes.model.pojo.Informatico;
import com.jorgelopezendrina.pcsincomponentes.model.pojo.Ordenador;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private Repository repository;
    private Informatico informatico;
    private Ordenador ordenador;
    private boolean rvelementos,crearInfor,creaOrdenador;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void borrarInformatico(long id) {
        repository.borrarInformatico(id);
    }

    public void devuelveInformatico(long id) {
        repository.devuelveInformatico(id);
    }

    public MutableLiveData<List<Informatico>> devuelveListaInformaticos() {
        return repository.devuelveListaInformaticos();
    }

    public void insertaInformatico(Informatico informatico) {
        repository.insertaInformatico(informatico);
    }

    public void actualizaInformatico(long id, Informatico informatico) {
        repository.actualizaInformatico(id, informatico);
    }

    public void borrarOrdenador(long id) {
        repository.borrarOrdenador(id);
    }

    public void devuelveOrdenador(long id) {
        repository.devuelveOrdenador(id);
    }

    public MutableLiveData<List<Ordenador>> devuelveListaOrdenador() {
        return repository.devuelveListaOrdenador();
    }

    public void insertaOrdenador(Ordenador ordenador) {
        repository.insertaOrdenador(ordenador);
    }

    public void actualizaOrdenador(long id, Ordenador ordenador) {
        repository.actualizaOrdenador(id, ordenador);
    }

    public Informatico getInformatico() {
        return informatico;
    }

    public void setInformatico(Informatico informatico) {
        this.informatico = informatico;
    }

    public Ordenador getOrdenador() {
        return ordenador;
    }

    public void setOrdenador(Ordenador ordenador) {
        this.ordenador = ordenador;
    }

    public boolean isRvelementos() {
        return rvelementos;
    }

    public void setRvelementos(boolean rvelementos) {
        this.rvelementos = rvelementos;
    }

    public boolean isCrearInfor() {
        return crearInfor;
    }

    public void setCrearInfor(boolean crearInfor) {
        this.crearInfor = crearInfor;
    }

    public boolean isCreaOrdenador() {
        return creaOrdenador;
    }

    public void setCreaOrdenador(boolean creaOrdenador) {
        this.creaOrdenador = creaOrdenador;
    }
}
