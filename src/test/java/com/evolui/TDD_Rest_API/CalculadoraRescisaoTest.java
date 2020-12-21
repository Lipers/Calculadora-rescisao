package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.service.CalculadoraFeriasIntegral;
import com.evolui.TDD_Rest_API.service.CalculadoraFeriasEmDobro;
import com.evolui.TDD_Rest_API.service.CalculadoraRescisao;
import com.evolui.TDD_Rest_API.service.CalculadoraRescisaoSemJustaCausa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class CalculadoraRescisaoTest {

    @Test
    void quandoCalcularRescisaoDeveriaRetornarValorCalculado() {
        CalculadoraRescisao calculadoraRescisao = new CalculadoraRescisaoSemJustaCausa();
        CalculadoraFeriasIntegral calculadoraFeriasRescisao = new CalculadoraFeriasEmDobro();
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");

        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);
        boolean fezAvisoPrevio = true;
        boolean mesIndenizado = true;
        double ferias = calculadoraRescisao.calcularRescisao(joao.getSalario(), dataInicioContrato, dataFimContrato, fezAvisoPrevio);
        double valorFerias = calculadoraFeriasRescisao.calcularFeriasNaoProporcionais(joao.getSalario());

        //TODO: CALCULADORA RESCISAO JUSTA CAUSA

        Assertions.assertEquals( 11115.23, ferias);
    }

}
