package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.service.CalculadoraIRRF;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class CalculadoraIRRFTest {

    @Test
    void quandoCalcularIRRFDeveriaRetornarvalorCalculado() {

        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);
        CalculadoraIRRF calculadoraIRRF = new CalculadoraIRRF();
        //TODO: CALCULADORA IRRF
    }

}
