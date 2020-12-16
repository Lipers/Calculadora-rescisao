package com.evolui.TDD_Rest_API.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class CalculadoraFeriasProporcionais {

    public double calcularFeriasProporcionais(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato) {

        long quantidadeMesesTrabalhados = ChronoUnit.MONTHS.between(dataInicioContrato, dataFimContrato);

        if (dataFimContrato.getDayOfMonth() < 15)
            quantidadeMesesTrabalhados -= 1;

        double valor = (salario / 12) * quantidadeMesesTrabalhados;
        return formatarParaDoubleDaStringComVirgula(valor);
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
