package com.evolui.TDD_Rest_API.service;

import static com.evolui.TDD_Rest_API.Util.FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal;

public class CalculadoraFeriasEmDobro implements CalculadoraFeriasIntegral {

    @Override
    public double calcularFeriasNaoProporcionais(double salario) {
        double acrescimoFerias = salario / 3;

        double ferias = arredondaApartirDaTerceiraCasaDecimal(salario + acrescimoFerias);

        int valorAdicional = 3;
        return ferias  * valorAdicional;
    }

}
