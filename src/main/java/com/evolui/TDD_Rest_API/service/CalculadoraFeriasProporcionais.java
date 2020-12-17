package com.evolui.TDD_Rest_API.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class CalculadoraFeriasProporcionais {

    public double calcularFeriasProporcionais(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato, boolean feriasIndenizadas) {
        double feriasIndenizadasAdicional = 0;

        if (feriasIndenizadas)
            feriasIndenizadasAdicional = 1 / 12f * (salario + (salario * 1 / 3f));

        long quantidadeMesesTrabalhados = ChronoUnit.MONTHS.between(dataInicioContrato, dataFimContrato) + 1;

        if (dataFimContrato.getDayOfMonth() < 15)
            quantidadeMesesTrabalhados -= 1;



        double feriasProporcionais = quantidadeMesesTrabalhados / 12f * (salario + (salario * 1 / 3)) + feriasIndenizadasAdicional;

        return formatarParaDoubleDaStringComVirgula(feriasProporcionais);
    }

    private double formatarParaDoubleDaStringComVirgula(double ferias) {
        DecimalFormat df = new DecimalFormat("##.00");
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number = null;

        try {
            number = format.parse(df.format(ferias));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return number.doubleValue();
    }

}
