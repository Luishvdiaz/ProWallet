package com.example.prowallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    Button regresar, btnGuardar, listaI;
    EditText valorIngreso, descripcion, descripcion2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        regresar = (Button)findViewById(R.id.regresar);
        listaI = (Button)findViewById(R.id.listaI);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        valorIngreso = (EditText)findViewById(R.id.valorIngreso);
        descripcion = (EditText)findViewById(R.id.descripcion);
        descripcion2 = (EditText)findViewById(R.id.descripcion2);


        regresar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent volver = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(volver);
            }
        });

        listaI.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(intent);

            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                ingresos Ingresos1 = new ingresos(valorIngreso.getText().toString(), descripcion.getText().toString(), descripcion2.getText().toString());
                Ingresos1.save();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Ingreso guardado con valor de $"+valorIngreso.getText().toString(), Toast.LENGTH_LONG);

                toast1.show();
            }
        });
    }
}
