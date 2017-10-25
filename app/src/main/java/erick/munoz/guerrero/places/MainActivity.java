package erick.munoz.guerrero.places;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import erick.munoz.guerrero.adapter.LugarAdapter;
import erick.munoz.guerrero.modelos.Lugar;

public class MainActivity extends AppCompatActivity {
RecyclerView miRecyclerLugares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miRecyclerLugares = (RecyclerView) findViewById(R.id.recyclerLugares);
        ArrayList<Lugar> lugares = new ArrayList<>();
        //
        lugares.add(new Lugar("Egipto","https://okdiario.com/img/2017/01/25/piramides-egipto-como-construyeron-d-620x349.jpg","Hay mucha arena"));
        lugares.add(new Lugar("Japón","http://www.puzzledelahistoria.com/wp-content/uploads/Jap%C3%B3n.jpg","Hay mucho anime"));
        lugares.add(new Lugar("Jordania","http://viajesviatamundo.com/images/imagenes_viajes/ORIENTE/viajes_jordania/viajes_jordania_petra_4.jpg","Hay muchas piedras"));
        lugares.add(new Lugar("México","https://cdnblog.mexicodestinos.com/blog/wp-content/uploads/2012/11/turismo-en-la-ciudad-de-mexico.jpg","Hay muchos narcos"));

        miRecyclerLugares.setLayoutManager(new GridLayoutManager(this,1));
        miRecyclerLugares.setHasFixedSize(true);
        miRecyclerLugares.setAdapter(new LugarAdapter(lugares,this));



    }
}
