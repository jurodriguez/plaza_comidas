package com.example.plaza_comidas.domain.util;

import java.time.LocalDate;
import java.time.Period;

public class UtilFechaHora {

    public static int calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}
