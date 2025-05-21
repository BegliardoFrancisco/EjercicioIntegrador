package ar.edu.utnfc.backend;


import java.util.ArrayList;
import java.util.List;

import ar.Responses.SueldoCategoria;
import ar.edu.utnfc.backend.Entities.Empleado;
import ar.edu.utnfc.backend.Entities.EmpleadoContratado;
import ar.edu.utnfc.backend.Entities.EmpleadoPermanente;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Informes {
    
    private ArrayList<Empleado> empleados;

    public void informe1() {
        System.out.println("Informe 1: Informar el mayor y menor sueldo por tipo y categoría mostrando todos los datos de cada Empleado.");

        System.out.println("Empleados contratados:");
        List<EmpleadoContratado> empleadosContratados = empleados.stream()
                .filter(empleado -> empleado instanceof EmpleadoContratado)
                .map(empleado -> (EmpleadoContratado) empleado)
                .toList();

        SueldoCategoria sueldoContratadoA = this.SueldoMinimoYMaximo(empleadosContratados, "A");
        SueldoCategoria sueldoContratadoB = this.SueldoMinimoYMaximo(empleadosContratados, "B");
        SueldoCategoria sueldoContratadoC = this.SueldoMinimoYMaximo(empleadosContratados, "C");

        System.out.println(sueldoContratadoA + "\n" + sueldoContratadoB + "\n" + sueldoContratadoC);

        System.out.println("Empleados permanentes:");
        List<EmpleadoPermanente> empleadosPermanentes = empleados.stream()
                .filter(empleado -> empleado instanceof EmpleadoPermanente)
                .map(empleado -> (EmpleadoPermanente) empleado)
                .toList();

        SueldoCategoria sueldoPermanenteA = this.SueldoMinimoYMaximo(empleadosPermanentes, "A");
        SueldoCategoria sueldoPermanenteB = this.SueldoMinimoYMaximo(empleadosPermanentes, "B");
        SueldoCategoria sueldoPermanenteC = this.SueldoMinimoYMaximo(empleadosPermanentes, "C");

        System.out.println(sueldoPermanenteA +"\n" + sueldoPermanenteB + "\n" + sueldoPermanenteC);
    }

    public void informe2() {
        System.out.println("Informe 2: Total de sueldos por tipo de empleado.");
        // Implementar lógica para el informe 2

        Double TotalSueldoEmpleadosContratados = empleados.stream()
                .filter(empleado -> empleado instanceof EmpleadoContratado)
                .map(empleado -> empleado.calcularSueldo())
                .reduce(0.0, Double::sum);
                
        System.out.println("Total de Sueldo de Empleados contratados: " + TotalSueldoEmpleadosContratados);

        Double TotalSueldoEmpleadosPermanentes = empleados.stream()
        .filter(empleado -> empleado instanceof EmpleadoPermanente)
        .map(empleado -> empleado.calcularSueldo())
        .reduce(0.0, Double::sum);

        System.out.println("Total de Sueldo de Empleados permanentes: " + TotalSueldoEmpleadosPermanentes);
    }

    public void informe3() {
        System.out.println("Informe 3: Porcentaje de salarios de empleados contratados sobre el total de salarios general.");
        // Implementar lógica para el informe 3

        List<EmpleadoContratado> empleadosContratados = empleados.stream()
                .filter(empleado -> empleado instanceof EmpleadoContratado)
                .map(empleado -> (EmpleadoContratado) empleado)
                .toList();

        Double PorcentajeSueldoEmpleadosContratados = empleadosContratados.stream()
                .map(empleado -> empleado.calcularSueldo())
                .reduce(0.0, Double::sum) / empleadosContratados.size();

        Double PorcentajeDeSueldoGeneral = empleados.stream()
                .map(empleado -> empleado.calcularSueldo())
                .reduce(0.0, Double::sum) / empleados.size();

        System.out.println("Porcentaje de Sueldo de Empleados Contratados: " + PorcentajeSueldoEmpleadosContratados);
        System.out.println("Porcentaje de Sueldo General: " + PorcentajeDeSueldoGeneral);
        System.out.println("Porcentaje de Sueldo de Empleados Contratados sobre el total de salarios general: " + (PorcentajeSueldoEmpleadosContratados / PorcentajeDeSueldoGeneral) * 100 + "%");
    }

    public void informe4() {
        System.out.println("Informe 4: Antigüedad promedio de empleados permanentes.");
        
        List<EmpleadoPermanente> empleadosPermanentes = empleados.stream()
                .filter(empleado -> empleado instanceof EmpleadoPermanente)
                .map(empleado -> (EmpleadoPermanente) empleado)
                .toList();

        Double antiguedadPromedio = empleadosPermanentes.stream()
                .map(empleado -> (double) empleado.calcularAntiguedad())
                .reduce(0.0, Double::sum) / empleadosPermanentes.size();

        System.out.println("Antigüedad promedio de empleados permanentes: " + antiguedadPromedio);


    }

    private SueldoCategoria SueldoMinimoYMaximo(List<? extends Empleado> empleados, String categoria) {
        SueldoCategoria resultado = new SueldoCategoria(categoria, 0.0, 0.0);

        Double sueldoMinimo =  empleados.stream()
            .filter(empleado -> empleado.getCategoria().getNombre().equals(categoria))
            .map(empleado -> empleado.calcularSueldo())
            .min(Double::compareTo)
            .orElse(0.0);

        Double sueldoMaximo = empleados.stream()
            .filter(empleado -> empleado.getCategoria().getNombre().equals(categoria))
            .map(empleado -> empleado.calcularSueldo())
            .max(Double::compareTo)
            .orElse(0.0);

        resultado.setSueldoMinimo(sueldoMinimo);
        resultado.setSueldoMaximo(sueldoMaximo);
        return resultado;
    }

}