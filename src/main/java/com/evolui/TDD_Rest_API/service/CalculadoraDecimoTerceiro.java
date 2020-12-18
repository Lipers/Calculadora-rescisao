package com.evolui.TDD_Rest_API.service;

import com.evolui.TDD_Rest_API.Util.FormatadorUtil;

import java.time.LocalDate;
import java.time.Month;

public class CalculadoraDecimoTerceiro {
    public double calcularDecimoTerceiro(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato) {

        CalculadoraTempoTrabalhado calculadoraTempoTrabalhado = new CalculadoraTempoTrabalhado();

        if (dataInicioContrato.getYear() < dataFimContrato.getYear())
            dataInicioContrato = LocalDate.of(dataFimContrato.getYear(), Month.JANUARY, 01);

        double mesesTrabalhados = calculadoraTempoTrabalhado.calculaMesesTrabalhados(dataInicioContrato, dataFimContrato);

        int ano = 12;
        return FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(mesesTrabalhados / ano * salario);
    }

    public double calcularDecimoTerceiroIndenizado(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato) {
        int ano = 12;
        float mesIndenizado = 1f;
        double resultado = FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(mesIndenizado / ano * salario);
        return resultado;
    }

}
