package com.evolui.TDD_Rest_API.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.evolui.TDD_Rest_API.Util.FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal;

public class CalculadoraFeriasProporcionais {

    public double calcularFeriasProporcionais(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato, boolean feriasIndenizadas) {
        double feriasIndenizadasAdicional = 0;

        if (feriasIndenizadas)
            feriasIndenizadasAdicional = 1 / 12f * (salario + (salario * 1 / 3f));

        long quantidadeMesesTrabalhados = ChronoUnit.MONTHS.between(dataInicioContrato, dataFimContrato) + 1;

        if (dataFimContrato.getDayOfMonth() < 15)
            quantidadeMesesTrabalhados -= 1;



        double feriasProporcionais = quantidadeMesesTrabalhados / 12f * (salario + (salario * 1 / 3)) + feriasIndenizadasAdicional;

        return arredondaApartirDaTerceiraCasaDecimal(feriasProporcionais);
    }
}
