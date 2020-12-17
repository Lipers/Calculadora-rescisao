package com.evolui.TDD_Rest_API.service;

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

        double valorDiasFracionados = 0.08 * salario * (dataFimContrato.getDayOfMonth() / 30f) ;

        System.out.println(valorDiasFracionados);

        return valorMesesCheios;
    }
}

//        double diasDoMesFracionado = 0.08 * quantidadeMesesTrabalhados * salario;

//         if(dataInicioContrato.getDayOfMonth() != 01) {
//            double valorProporcionalDataInicio = 0.08 * salario * (dataInicioContrato.getDayOfMonth() / 30f);
//        }
//
//        if(dataFimContrato.getDayOfMonth() >= 28) {
//            double valorProporcionalDataFim = 0.08 * salario * (dataInicioContrato.getDayOfMonth() / 30f);
//        }
