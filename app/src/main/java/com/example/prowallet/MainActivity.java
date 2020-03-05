package com.example.prowallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGasto, btnIngreso, btnActualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGasto = (Button)findViewById(R.id.btnGasto);
        btnIngreso = (Button)findViewById(R.id.btnIngreso);
        btnActualizar = (Button)findViewById(R.id.btnActualizar);

        final HelperDB ayudadb = new HelperDB(getApplicationContext());

        btnActualizar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SQLiteDatabase db = ayudadb.getWritableDatabase();
                ContentValues valores = new ContentValues();
                //valores.put(HelperDB.DatosTabla.COLUMN_ID,etId.detText().toString());

            }
        });

        btnIngreso.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
