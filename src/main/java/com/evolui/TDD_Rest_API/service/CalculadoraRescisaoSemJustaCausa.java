package com.evolui.TDD_Rest_API.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadoraRescisaoSemJustaCausa implements CalculadoraRescisao {


    public double calcularRescisao(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato, boolean avisoCumprido) {

        long anosTrabalhados = ChronoUnit.YEARS.between(dataInicioContrato, dataFimContrato);

        double AVI = 0;

        if (avisoCumprido) {
            AVI = salario * ((anosTrabalhados * 3) + 30) / 30;
        }

        int diasTrabalhadosUltimoMes = 18;
        int diasMes = 30;
        double saldoSalario = salario / diasMes * diasTrabalhadosUltimoMes;

        CalculadoraFeriasIntegral calculadoraSalario = new CalculadoraFeriasSimples();

        double ferias = calculadoraSalario.calcularFeriasNaoProporcionais(salario);

        return salario;
    }
}
