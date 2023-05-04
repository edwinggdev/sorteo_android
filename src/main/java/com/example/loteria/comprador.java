package com.example.loteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loteria.Entidades.Numero;
import com.example.loteria.Entidades.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class comprador extends AppCompatActivity {
    Button btSig,btReg;
    Button btValidar;
    TextView txCedula, txNombres, txTelefono, txCedulaId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprador);

        btSig = findViewById(R.id.btSig);
        btSig.setOnClickListener(evsig);
        btSig.setEnabled(false);
        btValidar = findViewById(R.id.btValidar);
        btValidar.setOnClickListener(evValidar);

        btReg = findViewById(R.id.btReg);
        btReg.setOnClickListener(evReg);
        btReg.setEnabled(false);
        txCedula = findViewById(R.id.txCedula);
        txNombres = findViewById(R.id.txNombres);
        txTelefono = findViewById(R.id.txTelefono);
        txCedulaId = findViewById(R.id.txCedulaId);

    }

    View.OnClickListener evsig = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent(getApplicationContext(), MainActivity.class);
            it.putExtra("cedula", txCedulaId.getText().toString());
            startActivity(it);
        }
    };

    View.OnClickListener evValidar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            btReg.setEnabled(false);
            String cedula = txCedula.getText().toString();
            Log.d("sorteo","ced" + cedula);
            Call<Usuario> call = RtfUsuariosCliente.getInstance().getMyApi().getUsuario(cedula);
            call.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    Log.d("sorteo","hubo rta");

                    Usuario u = response.body();
                    try{
                        Log.d("sorteo","usuario" + u.getCedula());
                        txNombres.setText(u.getNombres());
                        txTelefono.setText(u.getTelefono());
                        txCedulaId.setText(u.getId() + "");
                        btSig.setEnabled(true);
                        InputMethodManager imm =(InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }catch (Exception ex){
                        Log.d("sorteo","no usuario");
                        btReg.setEnabled(true);
                    }


                }

                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    Log.w("sorteo","Error:" + t.getMessage());
                }
            });
        }
    };


    View.OnClickListener evReg = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            btSig.setEnabled(false);
            String cedula = txCedula.getText().toString();
            String nombre = txNombres.getText().toString();
            String telefono = txTelefono.getText().toString();
            Usuario nuevo = new Usuario(cedula,nombre,telefono);
            Log.d("sorteo","ced" + cedula);
            Call<Void> call = RtfUsuariosCliente.getInstance().getMyApi().agregarUsuario(nuevo);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Log.d("sorteo","hubo rta");

                    try{
                        Log.d("sorteo","usuario" + response.body());

                        btSig.setEnabled(true);
                        btReg.setEnabled(false);
                        btValidar.setEnabled(false);
                        Toast.makeText(comprador.this,"Documento " + cedula + ", Registrado Correctamente", Toast.LENGTH_SHORT).show();
                    }catch (Exception ex){
                        Log.d("sorteo","no Registro");
                        btReg.setEnabled(true);
                    }


                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.w("sorteo","Error" + t.getMessage());
                }
            });
        }
    };

}