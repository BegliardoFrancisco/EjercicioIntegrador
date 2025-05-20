package ar.edu.utnfc.backend.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Empleado {
    
    int legajo;
    String nombre;
    double montobase;
    Categoria categoria;

    public abstract double calcularSueldo();
}
