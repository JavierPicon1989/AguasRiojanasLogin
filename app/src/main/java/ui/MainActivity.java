package ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aguasriojanas.R;

import java.util.HashMap;
import java.util.Map;

import modelo.Login;

public class MainActivity extends AppCompatActivity {

    TextView tv_usuario, tv_clase;
    Button btnIngresoMicro;

    Login usuarioLogin= new Login();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        tv_usuario = findViewById(R.id.tv_usuario);
        tv_clase = findViewById(R.id.tv_clase);
        btnIngresoMicro = findViewById(R.id.btnIngresoMicro);
        String usuario = getIntent().getStringExtra("user");
        String id_usuario = getIntent().getStringExtra("id_usuario");
        //int id_usuario1 = Integer.parseInt(id_usuario);
        tv_usuario.setText("Bienvenid@   " + usuario);
        tv_clase.setText(id_usuario);


        btnIngresoMicro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresoMicro();
            }
        });

    }

    public void ingresoMicro(){
        StringRequest request = new StringRequest(Request.Method.POST,
                "http://192.168.1.16/json/permisosAcceso.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.contains("administrador")){
                            Intent intent = new Intent(MainActivity.this, Micromedicion.class);

                            //intent.putExtra("id_usuario",usuarioLogin.usuarioParse.getId_usuario().toString());

                            startActivity(intent);
                        }else{

                            Toast.makeText(getApplicationContext(),
                                    "El usuario no tiene permmiso de acceso"+response, Toast.LENGTH_SHORT).show();
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
                params.put("id_user", usuarioLogin.getUsuarioParse().getId_usuario().toString());
                return params;
            }
        };
                Volley.newRequestQueue(this).add(request);
    }
}











