package ar.edu.utnfc.backend.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Categoria {
    String nombre;
    double coeficiente;
}
