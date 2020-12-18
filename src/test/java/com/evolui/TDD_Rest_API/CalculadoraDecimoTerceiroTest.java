package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.service.CalculadoraDecimoTerceiro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class CalculadoraDecimoTerceiroTest {

    @Test
    void quandoCalcularDecimoTerceiroSalarioDeveriaRetornarValorCalculado() {
        CalculadoraDecimoTerceiro calculadoDecimoTerceiro = new CalculadoraDecimoTerceiro();

        Funcionario funcionario = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500, "M");
        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);

        double decimoTerceiro = calculadoDecimoTerceiro.calcularDecimoTerceiro(funcionario.getSalario(), dataInicioContrato, dataFimContrato);

        Assertions.assertEquals(1250.0, decimoTerceiro);
    }

}
