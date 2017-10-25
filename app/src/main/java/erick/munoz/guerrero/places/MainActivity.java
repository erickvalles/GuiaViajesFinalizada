package erick.munoz.guerrero.places;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import erick.munoz.guerrero.adapter.LugarAdapter;
import erick.munoz.guerrero.modelos.Lugar;

public class MainActivity extends AppCompatActivity {
RecyclerView miRecyclerLugares;
    ArrayList<Lugar> lugares;
    LugarAdapter lugarAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miRecyclerLugares = (RecyclerView) findViewById(R.id.recyclerLugares);
        lugares = new ArrayList<>();


        miRecyclerLugares.setLayoutManager(new GridLayoutManager(this,1));
        miRecyclerLugares.setHasFixedSize(true);
        lugarAdapter = new LugarAdapter(lugares,this);
        miRecyclerLugares.setAdapter(lugarAdapter);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://148.202.89.227/LugaresApi/public/api/lugares";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Respuesta",response.substring(0,500));
                llenararreglo(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error","Pasó algo compa"+error.toString());
            }
        });

        queue.add(stringRequest);

    }

    private void llenararreglo(String respuesta){
        try {
            JSONArray array = new JSONArray(respuesta);
            for(int i = 0; i<=array.length()-1;i++){
                JSONObject object = array.getJSONObject(i);
                Lugar lugar = new Lugar(object.getString("nombre"),object.getString("foto"),object.getString("descripcion"));

                lugares.add(lugar);
            }

        lugarAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
