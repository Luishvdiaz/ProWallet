package com.example.prowallet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {


    Button regresar, home, consultar, borrar;
    ListView listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);



        regresar = (Button)findViewById(R.id.regresar);
        home = (Button)findViewById(R.id.home);
        consultar = (Button)findViewById(R.id.consultar);
        borrar = (Button)findViewById(R.id.borrar);
        listado= (ListView)findViewById(R.id.listado);

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Main4Activity.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿Realmende desea eliminar todos los registros de ingresos?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        List<ingresos> IngresosList = ingresos.listAll(ingresos.class);
                        ingresos.deleteAll(ingresos.class);
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Datos borrados", Toast.LENGTH_LONG);

                        toast1.show();
                        CargarvistaSQL();
                    }
                });
                dialogo1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        //finish();
                    }
                });
                dialogo1.show();
            }

        });

        regresar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent volver = new Intent(Main4Activity.this, Main2Activity.class);
                startActivity(volver);
            }
        });

        home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent volver = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(volver);
            }
        });

        consultar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CargarvistaSQL();
            }

        }));
    }
    public void CargarvistaSQL(){
        List<ingresos> IngresosList = ingresos.listAll(ingresos.class);
        ArrayList<String> lista1 = new ArrayList<String>();
        for(int i=0;i<IngresosList.size();i++){
            ingresos result = IngresosList.get(i);
            lista1.add(""+result.getId()+" - $"+result.getIngreso()+" - "+result.getDescripcion()+" - "+result.getHora_fecha());
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista1);
        listado.setAdapter(adaptador);
    }

}
