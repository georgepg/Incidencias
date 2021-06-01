package com.example.incidencias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterIncidencias extends RecyclerView.Adapter<AdapterIncidencias.IncidenciasHolder> {
    private List<Incidencia> mData;
    LayoutInflater mInflater;
    Context context;

    public AdapterIncidencias(List<Incidencia> mData, Context context) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public int getItemCount(){return mData.size();}

    public void setItems(List<Incidencia>items){mData = items;}

    @Override
    public IncidenciasHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new IncidenciasHolder(view);
    }

    @Override
    public void onBindViewHolder( IncidenciasHolder holder, int position) {
        holder.binData(mData.get(position));
    }


    public class IncidenciasHolder extends RecyclerView.ViewHolder{

        TextView Nombre;
        public IncidenciasHolder(View itemView) {
            super(itemView);
            Nombre = itemView.findViewById(R.id.txtNomIncidencia);
        }
        void binData(final Incidencia item){
            Nombre.setText(item.getName());
        }
    }

}
