package com.evolui.TDD_Rest_API.service;

import com.evolui.TDD_Rest_API.Util.FormatadorUtil;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


import static java.time.temporal.TemporalAdjusters.*;


public class CalculadoraFGTS {
    public double calcularFGTS(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato) {

        double quantidadeMesesTrabalhados = ChronoUnit.MONTHS.between(dataInicioContrato, dataFimContrato);
        int ultimoDiaDoMesDoFimDoContrato = dataFimContrato.with(dataFimContrato.getMonth()).with(lastDayOfMonth()).getDayOfMonth();
        double resultado = 0;
        if (ultimoDiaDoMesDoFimDoContrato == dataFimContrato.getDayOfMonth() && (dataInicioContrato.getMonth() != dataFimContrato.getMonth() || dataInicioContrato.getDayOfMonth() == 1)) {
            quantidadeMesesTrabalhados += 1;
        }
        else {
            double valorDiasFracionados = FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(0.08 * salario * (dataFimContrato.getDayOfMonth() / 30f));
            resultado += valorDiasFracionados;
        }
        resultado += 0.08 * quantidadeMesesTrabalhados * salario;
        return FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(resultado);
    }

    public double calcularFGTSAvisoIndenizadoOuDecimoTerceiroProporcional(Double valorAvisoIndenizado) {
        return FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(valorAvisoIndenizado * 0.08);
    }

    public double calculaMultaFGTS(double FGTS) {
        return FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(FGTS * 0.4);
    }
}
