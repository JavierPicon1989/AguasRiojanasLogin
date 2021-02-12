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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button btn_login;
    EditText et_usuario, et_contraseña;
    public static Usuario usuario;

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

                        try {
                            usuario = new Usuario();
                            JSONObject obj = new JSONObject(response);
                            usuario.setId_usuario(obj.getString("id"));
                            usuario.setEmail(obj.getString("email"));
                            usuario.setNombre(obj.getString("nombre"));
                            usuario.setPassword(obj.getString("password"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                            if(response.contains("email")){
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            //intent.putExtra("id_usuario", );
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


}