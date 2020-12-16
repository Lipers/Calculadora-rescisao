package com.evolui.TDD_Rest_API.service;

import java.time.LocalDate;

public interface CalculadoraRescisao {

    public double calcularRescisao(double salario, LocalDate dataInicioContrato, LocalDate dataFimContrato, boolean avisoCumprido);
}
