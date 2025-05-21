package ar.edu.utnfc.backend;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReaderHeaderAware;

import ar.edu.utnfc.backend.Entities.Categoria;
import ar.edu.utnfc.backend.Entities.Empleado;
import ar.edu.utnfc.backend.Entities.EmpleadoContratado;
import ar.edu.utnfc.backend.Entities.EmpleadoPermanente;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReadData {
    


 public ArrayList<Empleado> readData() {
    try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader("/home/francisco/backend/EjercicioIntegrador/src/main/data/empleados.csv"))) {
        Map<String, String> fila ;
        Map<String, Categoria> categorias = new HashMap<>();
        int contador = 0;
        ArrayList<Empleado> empleados = new ArrayList<>();

        while ((fila = reader.readMap()) != null) {
            int legajo = Integer.parseInt(fila.get("legajo"));
            String nombre = fila.get("nombre");
            String tipo = fila.get("tipo");
            String categoria = fila.get("categoria");
            LocalDate fecha = LocalDate.parse(fila.get("fecha"));
            double montoBase = Double.parseDouble(fila.get("montoBase"));

            Categoria cat;
            double coeficiente = 0.0;

            if (categorias.containsKey(categoria)) { 
                cat = categorias.get(categoria);

            } else if (categoria.equals("A")) {
                coeficiente = 1.2;
            } else if (categoria.equals("B")) {
                coeficiente = 1.0;        
            } else if (categoria.equals("C")) {
                coeficiente = 0.9;        
            } 

            cat = new Categoria(categoria, coeficiente);
            categorias.put(cat.getNombre(), cat);
            
            Empleado empleado= tipo.equals("PERMANENTE") 
            ? new EmpleadoPermanente(legajo, nombre, montoBase, cat, fecha) 
            : new EmpleadoContratado(legajo, nombre, montoBase, cat, fecha);      
            empleados.add(empleado);

            contador++;
            if (contador > 10) {
                break;
            }
            }

            return empleados;

    } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo CSV: " + e.getMessage(), e);

    }

 } 




}
