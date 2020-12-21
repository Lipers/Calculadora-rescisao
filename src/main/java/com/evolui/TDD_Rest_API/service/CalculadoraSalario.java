package com.evolui.TDD_Rest_API.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

public class CalculadoraSalario {

    public double calcularSaldoSalario(Double salario, long quantidadeTrabalho) {
        return (salario / 30) * quantidadeTrabalho;
    }

    public double calcularDecimoTerceiro(double salario, int quantidadeMesesTrabalhados) {
        return (salario / 12) * quantidadeMesesTrabalhados;
    }


}
