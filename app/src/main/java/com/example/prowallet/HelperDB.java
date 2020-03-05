package com.example.prowallet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {

    public static abstract class DatosTabla implements BaseColumns {
    public static final String TABLE_NAME = "cartera";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DINERO = "dinero";

    public static final String TEXT_TYPE = "TEXT";
    public static final String COMMA_SEP = ",";

    private static final String CREAR_TABLA_1 =
                "CREATE TABLE " + DatosTabla.TABLE_NAME + " (" +
                        DatosTabla.COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        DatosTabla.COLUMN_DINERO + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DatosTabla.TABLE_NAME;
    }


    public static abstract class DatosTabla_Ingresos implements BaseColumns {
        public static final String TABLE_NAME_I = "ingresos";
        public static final String COLUMN_ID_I = "id";
        public static final String COLUMN_VALOR = "valor";
        public static final String COLUMN_HF = "hora_fecha";
        public static final String COLUMN_DESCRIPCION = "descripcion";

        public static final String TEXT_TYPE = "TEXT";
        public static final String COMMA_SEP = ",";

        private static final String CREAR_TABLA_2 =
                "CREATE TABLE " + DatosTabla_Ingresos.TABLE_NAME_I + " (" +
                        DatosTabla_Ingresos.COLUMN_ID_I + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        DatosTabla_Ingresos.COLUMN_VALOR + "TEXT , " +
                        DatosTabla_Ingresos.COLUMN_HF + "TEXT , " +
                        DatosTabla_Ingresos.COLUMN_DESCRIPCION + " TEXT)";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DatosTabla_Ingresos.TABLE_NAME_I;
    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BDCartera.db";

    public HelperDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatosTabla_Ingresos.CREAR_TABLA_2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatosTabla_Ingresos.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
