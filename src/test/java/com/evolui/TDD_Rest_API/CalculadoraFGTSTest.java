package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.service.CalculadoraFGTS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class CalculadoraFGTSTest {

    @Test
    void quandoCalcularFGTSEmRescisaoDeveriaRetornarValorCalculado(){
        CalculadoraFGTS calculadoraFGTS = new CalculadoraFGTS();
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500, "M");
        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);

        boolean avisoCumpridoOuMesIndenizado = true;

        double saldoFGTS = calculadoraFGTS.calcularFGTS(joao.getSalario(), dataInicioContrato, dataFimContrato, avisoCumpridoOuMesIndenizado);

        Assertions.assertEquals( 1223.33, saldoFGTS);

    }
}
