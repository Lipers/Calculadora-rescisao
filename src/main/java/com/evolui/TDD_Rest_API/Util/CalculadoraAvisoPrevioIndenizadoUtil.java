package com.evolui.TDD_Rest_API.Util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class CalculadoraAvisoPrevioIndenizadoUtil {
    public static double calcular(double ultimoSalario, LocalDate dataInicioContrato, LocalDate dataFimContrato) {

        double quantidadeAnosTrabalhados = ChronoUnit.YEARS.between(dataInicioContrato, dataFimContrato);
        double diasAdicionais = quantidadeAnosTrabalhados * 3;

        if (diasAdicionais >= 60)
            diasAdicionais = 60;

        double resultado = ultimoSalario * ((diasAdicionais + 30) / 30);

        return resultado;
    }
}
