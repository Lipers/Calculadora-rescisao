package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.Util.CalculadoraAvisoPrevioIndenizadoUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class CalculadoraAvisoPrevioIndenizadoTest {

    @Test
    void quandoCalcularAvisoPrevioIndenizadoDeveriaRetornarValorCalculado() {
        CalculadoraAvisoPrevioIndenizadoUtil calculadoraAvisoPrevioIndenizado = new CalculadoraAvisoPrevioIndenizadoUtil();

        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);

        double resultadoCalculo = calculadoraAvisoPrevioIndenizado.calcular(joao.getSalario(), dataInicioContrato, dataFimContrato);

        Assertions.assertEquals( 2750.0, resultadoCalculo);
    }

    @Test
    void quandoCalcularAvisoPrevioIndenizadoNoCenarioQueDiasAdicionaisUltrapassemSessentaDeveriaRetornarSessentaDias() {
        CalculadoraAvisoPrevioIndenizadoUtil calculadoraAvisoPrevioIndenizado = new CalculadoraAvisoPrevioIndenizadoUtil();

        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataInicioContrato = LocalDate.of(1900, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);

        double resultadoCalculo = calculadoraAvisoPrevioIndenizado.calcular(joao.getSalario(), dataInicioContrato, dataFimContrato);

        Assertions.assertEquals( 7500, resultadoCalculo);
    }
}
