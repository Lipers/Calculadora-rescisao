package com.evolui.TDD_Rest_API.service;

import com.evolui.TDD_Rest_API.Util.CalculadoraAvisoPrevioIndenizadoUtil;
import com.evolui.TDD_Rest_API.Util.FormatadorUtil;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadoraINSSDesconto {

    public double calcularSobreSaldoSalario(Double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato) {
        CalculadoraSalario calculadoraSalario = new CalculadoraSalario();

        long diasTrabalhadosTotal = ChronoUnit.DAYS.between(dataInicioContrato, dataFimContrato);

        long diasTrabalhadosUltimoMes = 0;

        if (diasTrabalhadosTotal > 30) {
            diasTrabalhadosUltimoMes = dataFimContrato.getDayOfMonth();
        } else {
            diasTrabalhadosUltimoMes = ChronoUnit.DAYS.between(dataInicioContrato, dataFimContrato);
        }

        double saldoSalario = calculadoraSalario.calcularSaldoSalario(salario, diasTrabalhadosUltimoMes);

        return calcularTabelaINSSRetido(saldoSalario);
    }

    public double calcularSobreAvisoPrevio(Double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato) {

        double baseCalculo = CalculadoraAvisoPrevioIndenizadoUtil.calcular(salario, dataInicioContrato, dataFimContrato);

        return calcularTabelaINSSRetido(baseCalculo);
    }

    public double calcularSobreDecimoTerceiro(Double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato) {
        CalculadoraDecimoTerceiro calculadoraDecimoTerceiro = new CalculadoraDecimoTerceiro();

        double baseCalculo = calculadoraDecimoTerceiro.calcularDecimoTerceiro(salario, dataInicioContrato, dataFimContrato);

        return calcularTabelaINSSRetido(baseCalculo);
    }

    private double calcularTabelaINSSRetido(double saldoSalario) {

        if (saldoSalario <= 1045)
            return FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(saldoSalario * 0.075);
        if (saldoSalario <= 2089.60)
            return FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(saldoSalario * 0.09 - 15.67);
        if (saldoSalario <= 3134.40)
            return FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(saldoSalario * 0.12 - 78.36);
        if (saldoSalario <= 6101.06)
            return FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(saldoSalario * 0.09 - 141.06);

        return 713.08;
    }

    public double calcularINSSTotal(Double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato) {

        double totalINSS = calcularSobreSaldoSalario(salario,dataInicioContrato, dataFimContrato) +
                calcularSobreAvisoPrevio(salario ,dataInicioContrato, dataFimContrato) +
                calcularSobreDecimoTerceiro(salario, dataInicioContrato, dataFimContrato);

        return FormatadorUtil.arredondaApartirDaTerceiraCasaDecimal(totalINSS);
    }
}
