package ui;

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

import modelo.Usuario;

import com.example.aguasriojanas.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
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
                                //String us= jsonObject.getString("id");
                                usuarioParse.setId_usuario(jsonObject.getString("id"));
                                usuarioParse.setEmail(jsonObject.getString("email"));
                                usuarioParse.setNombre(jsonObject.getString("nombre"));
                                usuarioParse.setPassword(jsonObject.getString("password"));
                                System.out.println(usuarioParse);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Intent intent = new Intent(Login.this, MainActivity.class);

                            intent.putExtra("user",et_usuario.getText().toString());
                            intent.putExtra("password", et_contraseña.getText().toString());
                            //String id= usuarioParse.getId_usuario().toString();

                            //ACA ES DONDE ESTA LO QUE NO PUEDO RESOLVER
                            //intent.putExtra("id_usuario", id);
                            intent.putExtra("id_usuario", "1");

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


}