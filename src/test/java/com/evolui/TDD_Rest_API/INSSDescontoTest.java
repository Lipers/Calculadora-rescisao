package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.service.CalculadoraINSSDesconto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class INSSDescontoTest {

    @Test
    void quandoCalcularDescontoINSSSobreSaldoSalarioDeveriaRetornarValorCalculado() {

        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);
        CalculadoraINSSDesconto calculadoraINSSDesconto = new CalculadoraINSSDesconto();

        double valorINSSRetidoSobreSaldoSalario = calculadoraINSSDesconto.calcularSobreSaldoSalario(joao.getSalario(), dataInicioContrato, dataFimContrato);

        Assertions.assertEquals(119.33, valorINSSRetidoSobreSaldoSalario);

    }

    @Test
    void quandoCalcularDescontoINSSSobreAvisoPrevioDeveriaRetornarValorCalculado() {

        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);
        CalculadoraINSSDesconto calculadoraINSSDesconto = new CalculadoraINSSDesconto();

        double valorINSSRetidoSobreAvisoPrevio = calculadoraINSSDesconto.calcularSobreAvisoPrevio(joao.getSalario(), dataInicioContrato, dataFimContrato);

        Assertions.assertEquals(251.64, valorINSSRetidoSobreAvisoPrevio);

    }

    @Test
    void quandoCalcularDescontoINSSSobreDecimoTerceiroDeveriaRetornarValorCalculado() {

        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);
        CalculadoraINSSDesconto calculadoraINSSDesconto = new CalculadoraINSSDesconto();

        double valorINSSRetidoSobreAvisoPrevio = calculadoraINSSDesconto.calcularSobreDecimoTerceiro(joao.getSalario(), dataInicioContrato, dataFimContrato);

        Assertions.assertEquals(78.13, valorINSSRetidoSobreAvisoPrevio);

    }

    @Test
    void quandoCalcularDescontoINSSTotalDeveriaRetornarValorCalculado() {

        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);
        CalculadoraINSSDesconto calculadoraINSSDesconto = new CalculadoraINSSDesconto();

        double valorINSSRetidoSobreAvisoPrevio = calculadoraINSSDesconto.calcularINSSTotal(joao.getSalario(), dataInicioContrato, dataFimContrato);

        Assertions.assertEquals(449.10, valorINSSRetidoSobreAvisoPrevio);

    }


}
