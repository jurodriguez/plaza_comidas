package com.example.user.services.domain.util;

import java.time.LocalDate;
import java.time.Period;

public class UtilDateTime {

    private UtilDateTime() {
        throw new IllegalStateException("Utility class");
    }

    public static int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }
}
