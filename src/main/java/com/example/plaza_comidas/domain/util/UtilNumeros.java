package com.example.plaza_comidas.domain.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilNumeros {

    private UtilNumeros() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean esSoloNumero(String cadena) {
        Pattern patron = Pattern.compile("^\\d+$");
        Matcher matcher = patron.matcher(cadena);
        return matcher.matches();
    }
}
