package com.evolui.TDD_Rest_API.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadoraRescisaoSemJustaCausa implements CalculadoraRescisao {


    public double calcularRescisao(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato,
                                   boolean avisoCumpridoOuIndenizado) {
        double avisoCumpridoOuIndenizadoValorAdicional = 0;

        long anosTrabalhados = ChronoUnit.YEARS.between(dataInicioContrato, dataFimContrato);

        if (avisoCumpridoOuIndenizado) {
            int mesAviso = 1;
            float ano = 12f;
            avisoCumpridoOuIndenizadoValorAdicional = (mesAviso / ano) * salario;
        }





        int diasTrabalhadosUltimoMes = 18;
        int diasMes = 30;
        double saldoSalario = salario / diasMes * diasTrabalhadosUltimoMes;

        CalculadoraFeriasIntegral calculadoraSalario = new CalculadoraFeriasSimples();

        double ferias = calculadoraSalario.calcularFeriasNaoProporcionais(salario);

        return salario;
    }
}
