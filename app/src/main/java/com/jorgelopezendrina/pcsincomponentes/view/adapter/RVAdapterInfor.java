package com.jorgelopezendrina.pcsincomponentes.view.adapter;

import android.app.Activity;
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

public class RVAdapterInfor extends RecyclerView.Adapter<RVAdapterInfor.ViewHolder>{

    private List<Informatico> listaInformaticos;
    private NavController navC;
    private ViewModel viewModel;
    private Activity activity;

    public RVAdapterInfor(List<Informatico> listaInformaticos, Activity activity, NavController navC) {
        this.listaInformaticos = listaInformaticos;
        this.navC = navC;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RVAdapterInfor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_informatico, parent, false);
        viewModel = new ViewModelProvider((ViewModelStoreOwner) activity).get(ViewModel.class);
        ViewHolder holder = new ViewHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapterInfor.ViewHolder holder, int position) {
        holder.tvInfor.setText(listaInformaticos.get(position).getNombreInfor());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setInformatico(listaInformaticos.get(position));
                navC.navigate(R.id.ac_RVElementos_to_verInformatico);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaInformaticos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvInfor;
        ConstraintLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.consInfor);
            tvInfor = itemView.findViewById(R.id.tvInfor);
        }
    }
}
