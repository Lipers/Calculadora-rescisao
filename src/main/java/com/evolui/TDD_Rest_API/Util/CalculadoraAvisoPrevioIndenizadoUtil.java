package com.evolui.TDD_Rest_API.Util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class CalculadoraAvisoPrevioIndenizadoUtil {
    public static double calcular(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato) {

        double quantidadeAnosTrabalhados = ChronoUnit.YEARS.between(dataInicioContrato, dataFimContrato);
        double diasAdicionais = quantidadeAnosTrabalhados * 3;
        double resultado = salario * ((diasAdicionais + 30) / 30);

        return resultado;
    }
}
