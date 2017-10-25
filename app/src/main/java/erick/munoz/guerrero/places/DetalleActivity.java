package erick.munoz.guerrero.places;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import erick.munoz.guerrero.modelos.Lugar;

public class DetalleActivity extends AppCompatActivity {

    Lugar lugar;
    ImageView ivImagen;
    TextView tvTitulo, tvDetalles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        lugar = getIntent().getParcelableExtra("lugar");
        ivImagen = (ImageView) findViewById(R.id.ivImagenDetalle);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvDetalles = (TextView) findViewById(R.id.tvDetalles);

        Picasso.with(this).load(lugar.getFoto()).into(ivImagen);
        tvTitulo.setText(lugar.getNombre());
        tvDetalles.setText(lugar.getDescripcion());

    }
}
