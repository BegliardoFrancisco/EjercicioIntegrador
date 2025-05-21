package ar.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SueldoCategoria {

    String categoria;
    Double sueldoMinimo;
    Double sueldoMaximo;

    @Override
    public String toString() {
        return "{" +
                "\ncategoria='" + categoria + 
                ",\nsueldoMinimo=" + sueldoMinimo +
                ",\nsueldoMaximo=" + sueldoMaximo +
                "\n}";
    }

}
