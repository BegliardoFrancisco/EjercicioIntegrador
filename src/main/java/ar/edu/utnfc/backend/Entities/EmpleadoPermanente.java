package ar.edu.utnfc.backend.Entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmpleadoPermanente extends Empleado {

    int legajo;
    String nombre;
    double montoBase;
    Categoria categoria;
    LocalDate fechaDeIngreso;


    @Override
    public double calcularSueldo() {
        int antiguedad = LocalDate.now().getYear() - this.fechaDeIngreso.getYear();
        return this.montoBase * this.categoria.coeficiente * (1 + 0.02 * antiguedad);
    }
    
}
