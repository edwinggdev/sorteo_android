package com.example.loteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loteria.Adapters.ElegidosAdapter;
import com.example.loteria.Adapters.ImageAdapter;
import com.example.loteria.Adapters.NumerosAdapter;
import com.example.loteria.Entidades.Imagen;
import com.example.loteria.Entidades.Numero;
import com.example.loteria.Entidades.Venta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sorteo extends AppCompatActivity{
    ListView lv;
    List<Imagen> s = new ArrayList<Imagen>();
    RecyclerView rv,rvN,rvE;

    ArrayList<String> tImagen;
    ArrayList<String> tNumero;
    List<Imagen> listado;
    List<Numero> listadoNum;
    List<Numero> elegidos;
    Button btCancelar, btComprar, btBuscar;
    Context context;
    TextView tv_sorteo_nombre,tv_sorteo_precio, tv_sorteo_total, tx_sorteoId;
    String id  = "";
    Double total;
    String cedula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteo);
        context = getApplicationContext();

        elegidos = new ArrayList<>();


        rv = findViewById(R.id.rvImagenes);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true));

        rvN = findViewById(R.id.rvNumeros);
        rvN.setLayoutManager(new GridLayoutManager(this,4));

        tv_sorteo_nombre = findViewById(R.id.tv_sorteo_nombre);
        tv_sorteo_precio = findViewById(R.id.tv_sorteo_precio);
        tv_sorteo_total = findViewById(R.id.tv_sorteo_total);
        tx_sorteoId = findViewById(R.id.txSorteoId);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            Log.d("sorteo", "sorteoID" + bundle.getInt ("eid") + "");
            tx_sorteoId.setText( "" + bundle.getInt("eid"));
            tx_sorteoId.setText( "" + bundle.getInt("eid"));
            id = bundle.getInt("eid")+ "";
            String nombre = bundle.getString("nombre");
            Double precio = bundle.getDouble("precio");
            tv_sorteo_nombre.setText(nombre);
            tv_sorteo_precio.setText(precio + "");
            Log.d("sorteo","cedulaid:"+bundle.getString("cedula"));
            cedula = bundle.getString("cedula");
        }


        Log.d("sorteo", "previo a...");
        getImages();
        getNumeros();

        btCancelar = findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(evCancelar);

        btComprar = findViewById(R.id.btComprar);
        btComprar.setOnClickListener(evComprar);

        btBuscar = findViewById(R.id.btBuscar);
        btBuscar.setOnClickListener(evBuscar);

        rvE = findViewById(R.id.rvElegidos);
        rvE.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getImages() {

        Call<List<Imagen>> call = RtfImagesCliente.getInstance().getMyApi().getImages(id);
        call.enqueue(new Callback<List<Imagen>>() {

            @Override
            public void onResponse(Call<List<Imagen>> call, Response<List<Imagen>> response) {
                Log.d("sorteo", "in OnResponse...");
                listado =  response.body();
                Log.d("sorteo","tamaño = "+  response.body());

                tImagen = new ArrayList<String>();
                for(int i = 0; i < listado.size(); i++){
                    Log.d("sorteo", listado.get(i).getTexto());
                    tImagen.add(listado.get(i).getTexto());
                    Log.d("sorteo","url = "+  listado.get(i).getUrl());
                }

                rv.setAdapter(new ImageAdapter(getApplicationContext(),listado));
                Log.d("sorteo","rv listo");

            }

            @Override
            public void onFailure(Call<List<Imagen>> call, Throwable t) {
                Log.d("sorteo", "ERror images:" + t.getMessage());
            }
        });
    }

    private Boolean validar(int numero){
        if(!elegidos.isEmpty())
            for (Numero elegido : elegidos) {
                if (elegido.getNumero().equals(numero + "")) {
                    return true;
                }
            }
        Log.d("sorteo",numero + "valido para elegir");
        return false;

    }

    private void eliminar(int posicion){

        elegidos.remove(posicion);
        refrescar();
    }

    private void registrar(int numero){
        if(elegidos.size() >=4){
            Toast.makeText(context,"Cantidad de Numeros Completa",Toast.LENGTH_SHORT).show();
        }else {
            Numero n = new Numero(numero + "");
            elegidos.add(n);
            refrescar();


        }
    }

    private void refrescar(){
        ElegidosAdapter ea = new ElegidosAdapter(context, elegidos);
        ea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(sorteo.this);
                builder.setMessage("Desea Eliminar este Numero?")
                        .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context,"Numero Eliminado",Toast.LENGTH_SHORT).show();
                                eliminar(rvE.getChildAdapterPosition(v));

                                                  }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create().show();
            }
        });
        rvE.setAdapter(ea);

        total = elegidos.size() * Double.parseDouble(tv_sorteo_precio.getText().toString());
        tv_sorteo_total.setText(total.toString());
        Log.d("sorteo", "cargado RV");
    }

    private void getNumeros() {
        Log.d("sorteo","Solicitando numeros del sorteoId" + id);
        Call<List<Numero>> call = RtfNumerosCliente.getInstance().getMyApi().getNumeros(id);
        call.enqueue(new Callback<List<Numero>>() {

            @Override
            public void onResponse(Call<List<Numero>> call, Response<List<Numero>> response) {
                Log.d("sorteo", "in numeros response..."+ response.body());
                listadoNum =  response.body();
                //Log.d("sorteo","Response = "+ listadoNum.get(1).getNumero() );

                /*tNumero = new ArrayList<String>();
                for(int i = 0; i < listadoNum.size(); i++){
                    Log.d("sorteo", listadoNum.get(i).getNumero());
                    tNumero.add(listadoNum.get(i).getNumero());
                }*/
                NumerosAdapter na = new NumerosAdapter(context,listadoNum);

                na.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("sorteo","Presionado: "+ listadoNum.get(rvN.getChildAdapterPosition(v)).getNumero() );//
                        int nro = Integer.parseInt(listadoNum.get(rvN.getChildAdapterPosition(v)).getNumero());
                        if(validar(nro)){
                            Toast.makeText(context,"Numero ya seleccionado",Toast.LENGTH_SHORT).show();
                        }else{
                            registrar(nro);
                        }

                    }
                });

                rvN.setAdapter(na);
                Log.d("sorteo","rvN listo");
            }

            @Override
            public void onFailure(Call<List<Numero>> call, Throwable t) {
                Log.d("sorteo", "ERror Numeros:" + t.getMessage());
            }
        });
    }

    View.OnClickListener evCancelar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(sorteo.this, "Saliendo..",Toast.LENGTH_SHORT).show();
            Intent itCancelar = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(itCancelar);

        }
    };

    View.OnClickListener evComprar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /*Toast.makeText(sorteo.this, "Compra Exitosa",Toast.LENGTH_SHORT).show();
            Intent itCancelar = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(itCancelar);*/
            if(elegidos.size() == 0){
                Toast.makeText(sorteo.this, "Selecciona numeros",Toast.LENGTH_SHORT).show();
            }else {
                String numero1 = elegidos.get(0).getNumero();
                String numero2 = "";
                String numero3 = "";
                String numero4 = "";
                try{  numero2=elegidos.get(1).getNumero();  }catch (Exception ex){ Log.d("sorteo","numero 2 no existe"); };
                try{  numero2=elegidos.get(2).getNumero();  }catch (Exception ex){ Log.d("sorteo","numero 3 no existe"); };
                try{  numero2=elegidos.get(3).getNumero();  }catch (Exception ex){ Log.d("sorteo","numero 4 no existe"); };
                total = Double.parseDouble((String) tv_sorteo_total.getText());
                int sorteoId = Integer.parseInt(tx_sorteoId.getText() + "");
                Log.d("sorteo" , "Sid:"+sorteoId);
                Venta venta = new Venta(sorteoId,cedula,numero1,numero2,numero3,numero4,total);
                Log.d("sorteo","ced" + cedula);

                Call<Venta> call = RtfVentasCliente.getInstance().getMyApi().agregarVenta(venta);
                call.enqueue(new Callback<Venta>() {
                    @Override
                    public void onResponse(Call<Venta> call, Response<Venta> response) {
                        Log.d("sorteo","hubo rta");

                        try{
                            Log.d("sorteo","venta" + response.body());
                            Venta res = response.body();
                            AlertDialog.Builder builder = new AlertDialog.Builder(sorteo.this);
                            builder.setMessage("Compra Exitosa \n" +
                                    "Boleto : " + res.getBoleto() + "\n" +
                                    "Comprador : " + res.getComprador() + "\n" +
                                    "Valor: $ " +  res.getTotal() )
                                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent itCancelar = new Intent(context, MainActivity.class);
                                            startActivity(itCancelar);
                                        }
                                    });
                            // Create the AlertDialog object and return it
                            builder.create().show();
                        }catch (Exception ex) {
                            Log.d("sorteo", "no Registro");

                        }


                    }

                    @Override
                    public void onFailure(Call<Venta> call, Throwable t) {
                        Log.w("sorteo","Error" + t.getMessage());
                    }
                });

            }

        }
    };

    View.OnClickListener evBuscar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            TextView b1,b2,b3,b4;
            b1 = findViewById(R.id.txBusca1);
            b2 = findViewById(R.id.txBusca2);
            b3 = findViewById(R.id.txBusca3);
            b4 = findViewById(R.id.txBusca4);

            List<Numero> encontrados = new ArrayList<Numero>();;
            String busqueda = b1.getText().toString()+b2.getText().toString()+b3.getText().toString()+b4.getText().toString();
            Log.d("sorteo", "Buscar:" + busqueda  );
            if(!listadoNum.isEmpty())
                for (Numero listado : listadoNum) {
                    Log.d("sorteo", "Compara:" + listado.getNumero() + "<>" + busqueda  );
                    if (listado.getNumero().startsWith(busqueda)) {
                       encontrados.add(listado);
                    }
                }
            NumerosAdapter na = new NumerosAdapter(context,encontrados);
            na.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("sorteo","Presionado: "+ encontrados.get(rvN.getChildAdapterPosition(v)).getNumero() );//
                    int nro = Integer.parseInt(encontrados.get(rvN.getChildAdapterPosition(v)).getNumero());
                    if(validar(nro)){
                        Toast.makeText(context,"Numero ya seleccionado",Toast.LENGTH_SHORT).show();
                    }else{
                        registrar(nro);
                    }

                }
            });

            rvN.setAdapter(na);
            Log.d("sorteo", "Numeros encontrados");
        }
    };

}