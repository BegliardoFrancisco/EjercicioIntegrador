package ar.edu.utnfc.backend.Entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmpleadoContratado extends Empleado {

    int legajo;
    String nombre;
    double montobase;
    Categoria categoria;
    LocalDate fechaDeLocalDate;


    @Override
    public double calcularSueldo() {
        double incremento = this.calcularIncremento();
        if (incremento == 0.0) {
            throw new IllegalArgumentException("Categoria no válida");
        }
        return this.montobase * this.categoria.coeficiente * (1 + incremento); 
    }
    
    private double calcularIncremento() {
        if (this.categoria.nombre.equals("A")) {
            return 0.1;
        } 
        else if (this.categoria.nombre.equals("B")) {
            return 0.05;
        } 
        else if (this.categoria.nombre.equals("C")) {
            return 0.02;
       }
       return 0.0;
    }
}
