package com.jorgelopezendrina.pcsincomponentes.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgelopezendrina.pcsincomponentes.R;
import com.jorgelopezendrina.pcsincomponentes.model.pojo.Informatico;
import com.jorgelopezendrina.pcsincomponentes.viewmodel.ViewModel;

import java.util.List;

public class RVIdInfo extends RecyclerView.Adapter<RVIdInfo.ViewHolder>{

    private List<Informatico> listaMontadores;
    private TextView etIdInforCreador;
    private View viewAux;


    public RVIdInfo(List<Informatico> listaMontadores, View viewAux) {
        this.listaMontadores = listaMontadores;
        this.viewAux = viewAux;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_infor_id, parent, false);
        etIdInforCreador = viewAux.findViewById(R.id.etIdInforCreador);
        ViewHolder holder = new ViewHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.idInfor.setText(String.valueOf(listaMontadores.get(position).getId()));
        holder.nombreInfor.setText(listaMontadores.get(position).getNombreInfor());
        holder.consID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etIdInforCreador.setText(String.valueOf(listaMontadores.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaMontadores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idInfor;
        TextView nombreInfor;
        ConstraintLayout consID;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idInfor = itemView.findViewById(R.id.tvInforID);
            nombreInfor= itemView.findViewById(R.id.tvInforN);
            consID = itemView.findViewById(R.id.constID);
        }
    }
}
