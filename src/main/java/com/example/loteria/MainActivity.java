package com.example.loteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.loteria.Adapters.ImageAdapter;
import com.example.loteria.Adapters.SorteoAdapter;
import com.example.loteria.Entidades.Imagen;
import com.example.loteria.Entidades.Sorteo;
import com.example.loteria.ViewHolders.MySorteoHolder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btSig;
    Context contexto;
    SorteoAdapter sa;
    ArrayList<String> tSorteo;
    List<Sorteo> listado;
    String cedula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contexto = getApplicationContext();
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            Log.d("sorteo", "cedula id: " + bundle.getString("cedula") + "");
            cedula = bundle.getString("cedula") + "";
        }

        List<Sorteo> s = new ArrayList<Sorteo>();

        RecyclerView rvSorteos = findViewById(R.id.rvSorteos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvSorteos.setLayoutManager(llm);

        Call<List<Sorteo>> call = RtfSorteCliente.getInstance().getMyApi().getSorteos();
            call.enqueue(new Callback<List<Sorteo>>() {

                @Override
                public void onResponse(Call<List<Sorteo>> call, Response<List<Sorteo>> response) {
                    Log.d("sorteo", "in OnResponse...");
                    listado =  response.body();
                    Log.d("sorteo","Response = "+ listado.get(1).getNombre());

                    /*tSorteo = new ArrayList<String>();
                    for(int i = 0; i < listado.size(); i++){
                        Log.d("sorteo", listado.get(i).getNombre());
                        tSorteo.add(listado.get(i));
                    }*/
                    sa = new SorteoAdapter(contexto,listado);
                    sa.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            Log.d("sorteo", "Presionado: " );
                            Intent it = new Intent(contexto,sorteo.class);
                            it.putExtra("eid", listado.get(rvSorteos.getChildAdapterPosition(v)).getId());
                            it.putExtra("nombre",listado.get(rvSorteos.getChildAdapterPosition(v)).getNombre());
                            it.putExtra("precio",listado.get(rvSorteos.getChildAdapterPosition(v)).getValorb());
                            it.putExtra("cedula", cedula);
                            startActivity(it);
                        }
                    });
                    DividerItemDecoration dd = new DividerItemDecoration(MainActivity.this,llm.getOrientation());
                    rvSorteos.addItemDecoration(dd);
                    rvSorteos.setAdapter(sa);
                    Log.d("sorteo","rv listo");

                }

                @Override
                public void onFailure(Call<List<Sorteo>> call, Throwable t) {
                    Log.d("sorteo", "ERror:" + t.getMessage());
                  }
            });



    }

    View.OnClickListener evCompra = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent(getApplicationContext(), sorteo.class);
            startActivity(it);
        }
    };
}