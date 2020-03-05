package com.example.prowallet;

import com.orm.SugarRecord;

public class ingresos extends SugarRecord {

    String  ingreso, descripcion, hora_fecha;

    public ingresos() {
    }

    public ingresos(String ingreso, String descripcion, String hora_fecha) {
        this.ingreso = ingreso;
        this.descripcion = descripcion;
        this.hora_fecha = hora_fecha;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHora_fecha() {
        return hora_fecha;
    }

    public void setHora_fecha(String hora_fecha) {
        this.hora_fecha = hora_fecha;
    }
}
