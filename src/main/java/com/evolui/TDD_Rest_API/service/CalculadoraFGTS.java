package com.evolui.TDD_Rest_API.service;

import com.evolui.TDD_Rest_API.Util.CalculadoraAvisoPrevioIndenizadoUtil;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class CalculadoraFGTS {
    public double calcularFGTS(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato, boolean avisoCumpridoOuMesIndenizado) {

        double quantidadeMesesTrabalhados = ChronoUnit.MONTHS.between(dataInicioContrato, dataFimContrato);

        if (avisoCumpridoOuMesIndenizado)
            quantidadeMesesTrabalhados += 1;

        double valorMesesCheios = 0.08 * quantidadeMesesTrabalhados * salario;

        double valorDiasFracionados = 0.08 * salario * (dataFimContrato.getDayOfMonth() / 30f);

        double valorAvisoPrevioIndenizatorio = 0.08 * CalculadoraAvisoPrevioIndenizadoUtil.calcular(salario, dataInicioContrato, dataFimContrato);

        return valorMesesCheios;
    }
}
