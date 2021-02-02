package com.example.aguasriojanas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button btn_login;
    EditText et_usuario, et_contraseña;
    Usuario  usuarioParse;



@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login =findViewById(R.id.btn_login);
        et_usuario =findViewById(R.id.et_usuario);
        et_contraseña =findViewById(R.id.et_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                //jsonParse();
            }
        });
}

        public void login(){
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.16/json/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.contains("email")){
                            jsonParse();

                            Intent intent = new Intent(Login.this, MainActivity.class);
                            //intent.putExtra("usuarioClass",usuarioView.getNombre());
                            intent.putExtra("user",et_usuario.getText().toString());
                            intent.putExtra("password", et_contraseña.getText().toString());
                            startActivity(intent);
                            } else{
                            Toast.makeText(getApplicationContext(),
                                    "Usuario o password incorrecto"+response, Toast.LENGTH_SHORT).show();
                        }

                        }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params= new HashMap<>();
                params.put("usuario", et_usuario.getText().toString());
                params.put("password", et_contraseña.getText().toString());
                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);

        }


        //Metodo para castear un JSON enviado desde php
        public void jsonParse(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
            Request.Method.GET,
            "http://192.168.1.16/json/login.php", null, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            int size = response.length();
            for(int i=0;i<size;i++){
                try {
                    JSONObject jsonObject = new JSONObject(response.get(i).toString());
                    String nombre= jsonObject.getString("nombre");
                    String email = jsonObject.getString("email");
                    Integer id_usuario = jsonObject.getInt("id");
                    //String password = jsonObject.getString("password");

                    //CREO UN OBJETO DEL TIPO USUARIO PARA SETEAR SUS VALORES
                    usuarioParse = new Usuario(email,nombre,id_usuario);

                }catch (JSONException e){
                    e.printStackTrace();
                }

             }
        }
        }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }

    );

        }

}