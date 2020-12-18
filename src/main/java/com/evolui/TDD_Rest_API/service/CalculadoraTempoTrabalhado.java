package com.evolui.TDD_Rest_API.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class CalculadoraTempoTrabalhado {

    public double calculaAnosTrabalhados(LocalDate dataInicioContrato, LocalDate dataFimContrato) {
        return ChronoUnit.YEARS.between(dataInicioContrato, dataFimContrato);
    }

    public double calculaMesesTrabalhados(LocalDate dataInicioContrato, LocalDate dataFimContrato) {
        if (ChronoUnit.DAYS.between(dataInicioContrato, dataFimContrato) < 28)
            return ChronoUnit.MONTHS.between(dataInicioContrato, dataFimContrato);
        return ChronoUnit.MONTHS.between(dataInicioContrato, dataFimContrato) + 1;
    }

    public double calculaDiasProporcionaisTrabalhadosNoMes(LocalDate dataInicioContrato, LocalDate dataFimContrato) {

        double quantidadeMesesTrabalhados = ChronoUnit.DAYS.between(dataInicioContrato, dataFimContrato);
        double mod = quantidadeMesesTrabalhados % 365;
        int mesesTrabalhadoInteiros = (int) (mod / 30);
        double mesesTrabalhadoTotal = mod / 30;
        double valorFracionado = (mesesTrabalhadoTotal - mesesTrabalhadoInteiros);
        double diasTrabalhadosProporcionais = Math.round((30 * (valorFracionado * 100)) / 100);
        return diasTrabalhadosProporcionais;
    }

}
