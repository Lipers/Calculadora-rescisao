package com.evolui.TDD_Rest_API.service;

import static com.evolui.TDD_Rest_API.Util.FormatadorUtil.formatarParaDoubleDaStringComVirgula;

public class CalculadoraFeriasSimples implements CalculadoraFeriasIntegral {

    @Override
    public double calcularFeriasNaoProporcionais(double salario) {
        double acrescimoFerias = salario / 3;

        double ferias = formatarParaDoubleDaStringComVirgula(ferias = salario + acrescimoFerias);

        return ferias;
    }

}
