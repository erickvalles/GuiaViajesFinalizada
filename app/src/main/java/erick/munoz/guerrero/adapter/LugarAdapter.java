package erick.munoz.guerrero.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import erick.munoz.guerrero.modelos.Lugar;
import erick.munoz.guerrero.places.DetalleActivity;
import erick.munoz.guerrero.places.R;

/**
 * Created by Lenovo-PC on 18/10/2017.
 */

public class LugarAdapter extends RecyclerView.Adapter<LugarAdapter.ViewHolder> {
    ArrayList<Lugar> lugares;
    Context context;

    public LugarAdapter(ArrayList<Lugar> lugares, Context context) {
        this.lugares = lugares;
        this.context = context;
    }

    @Override
    public LugarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View vistaLugar = LayoutInflater.from(context).inflate(R.layout.layout_elemento,parent,false);
        ViewHolder lugarViewHolder = new ViewHolder(vistaLugar);
        vistaLugar.setTag(lugarViewHolder);

        return lugarViewHolder;
    }

    @Override
    public void onBindViewHolder(LugarAdapter.ViewHolder holder, final int position) {
        holder.tvNombre.setText(lugares.get(position).getNombre());
        Picasso.with(context).load(lugares.get(position).getFoto()).into(holder.ivFondo);
        holder.btnDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, DetalleActivity.class);
                i.putExtra("lugar",lugares.get(position));
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lugares.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFondo;
        TextView tvNombre;
        Button btnDetalles;
        public ViewHolder(View itemView) {
            super(itemView);
            ivFondo = (ImageView) itemView.findViewById(R.id.ivFondo);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombreLugar);
            btnDetalles = (Button) itemView.findViewById(R.id.btnDetalles);
        }
    }
}
