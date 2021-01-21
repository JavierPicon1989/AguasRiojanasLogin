package com.example.aguasriojanas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //ListView listaResultados;
    TextView tv_usuario;
    Login usuarioView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        //listaResultados = (ListView)findViewById(R.id.lv_resultados);
        tv_usuario = findViewById(R.id.tv_usuario);
        String usuario = getIntent().getStringExtra("user");
        String contraseña = getIntent().getStringExtra("password");
        String usuarioClass = getIntent().getStringExtra("usuarioClass");
        tv_usuario.setText("Bienvenid@ " + usuarioClass );
        //+ usuarioView.usuarioView.getNombre()





    }
}

          /*public void mostrarDatos(String URL){
              Toast.makeText(getApplicationContext(),""+URL,Toast.LENGTH_SHORT).show();

              RequestQueue queue = Volley.newRequestQueue(this);
              StringRequest stringRequest= new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                  @Override
                  public void onResponse(String response) {
                      response = response.replace("[]", ",");
                      if (response.length() > 0) {
                          try {
                              JSONArray ja = new JSONArray(response);
                              Log.i("sizejson", "" + ja.length());
                              cargarListView();
                          } catch (JSONException e) {
                              e.printStackTrace();
                          }
                      }

                  }
              }, new Response.ErrorListener() {
                  @Override
                  public void onErrorResponse(VolleyError error) {

                  }
              });
              queue.add(stringRequest);
          }

        public void cargarListView(JSONArray ja){
         ArrayList<String> lista = new ArrayList<>();

              for (int i=0;i<ja.length();i++){
                  try {
            lista.add(ja.getString(i)+""+ja.getString(i+1));

             }catch (JSONException e){
            e.printStackTrace();
                }
                }


            String usuario = getIntent().getStringExtra("user");
            String contraseña = getIntent().getStringExtra("password");
            ArrayList contenido = new ArrayList<>();
            contenido.add(usuario+contraseña);
              ArrayAdapter<String> adaptador= new ArrayAdapter<String>
                      (this, android.R.layout.simple_expandable_list_item_2,contenido );
              listaResultados.setAdapter(adaptador);
        }*/








