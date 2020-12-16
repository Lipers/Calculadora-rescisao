package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.service.CalculadoraFeriasIntegral;
import com.evolui.TDD_Rest_API.service.CalculadoraFeriasEmDobro;
import com.evolui.TDD_Rest_API.service.CalculadoraFeriasProporcionais;
import com.evolui.TDD_Rest_API.service.CalculadoraFeriasSimples;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class CalculadoraFeriasTest {

    @Test
    void quandoCalcularFeriasSimplesDeveriaRetornarValorCalculado() {
        CalculadoraFeriasIntegral calculadoraFeriasSimples = new CalculadoraFeriasSimples();
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 4000, "M");

        double ferias = calculadoraFeriasSimples.calcularFeriasNaoProporcionais(joao.getSalario());

        Assertions.assertEquals(5333.33, ferias);
    }

    @Test
    void quandoCalcularFeriasEmDobroDeveriaRetornarValorCalculado() {
        CalculadoraFeriasIntegral calculadoraFeriasEmDobro = new CalculadoraFeriasEmDobro();
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500, "M");

        double ferias = calculadoraFeriasEmDobro.calcularFeriasNaoProporcionais(joao.getSalario());

        Assertions.assertEquals(9999.99, ferias);
    }

    @Test
    void quandoCalcularFeriasProporcionaisDeveriaRetornarValorCalculado() {
        CalculadoraFeriasProporcionais calculadoraFeriasProporcionais = new CalculadoraFeriasProporcionais();
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 4000, "M");

        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2019, Month.APRIL, 14);
        double ferias = calculadoraFeriasProporcionais.calcularFeriasProporcionais(joao.getSalario(), dataInicioContrato, dataFimContrato);

        Assertions.assertEquals(666.67, ferias);
    }
}
