package modelo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import ui.MainActivity;
import com.example.aguasriojanas.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button btn_login;
    EditText et_usuario, et_contraseña;
    Usuario usuarioParse ;

    public Usuario getUsuarioParse() {
        return usuarioParse;
    }

    public void setUsuarioParse(Usuario usuarioParse) {
        this.usuarioParse = usuarioParse;
    }

    @Override
    public String toString() {
        return "Login{" +
                "usuarioParse=" + usuarioParse +
                '}';
    }

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
            }
        });
}

        public void login(){
        StringRequest request = new StringRequest(Request.Method.POST,
                "http://192.168.1.16/json/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.contains("email")){
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                usuarioParse.setId_usuario(jsonObject.getString("id_usuario"));
                                usuarioParse.setEmail(jsonObject.getString("email"));
                                usuarioParse.setNombre(jsonObject.getString("nombre"));
                                usuarioParse.setPassword(jsonObject.getString("password"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            Intent intent = new Intent(Login.this, MainActivity.class);

                            intent.putExtra("user",et_usuario.getText().toString());
                            intent.putExtra("password", et_contraseña.getText().toString());
                            intent.putExtra("id_usuario", usuarioParse.getId_usuario().toString());
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
        /*public void jsonParse(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
            Request.Method.GET,
            "http://192.168.1.16/json/login.php",
                null, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            int size = response.length();
            for(int i=0;i<size;i++){
                try {
                    JSONObject jsonObject = new JSONObject(response.get(i).toString());
                    String nombre= jsonObject.getString("nombre");
                    String email = jsonObject.getString("email");
                    String password = jsonObject.getString("password");
                    Integer id_usuario = jsonObject.getInt("id_usuario");

                    //INICIALIZO UN OBJETO DEL TIPO USUARIO PARA SETEAR SUS VALORES

                    usuarioParse = new Usuario(email, nombre, password, id_usuario);

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

        }*/

}