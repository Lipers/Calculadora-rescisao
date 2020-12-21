package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraSalarioTest {

    @Test
    void quandoCalcularSalarioDeveriaRetornarQuantidadeBaseadoNosDiasQueTrabalhou() {
        CalculadoraSalario calculadoraSalario = new CalculadoraSalario();
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M");

        double salario = calculadoraSalario.calcularSaldoSalario(joao.getSalario(), 15);

        Assertions.assertEquals(10000.0, salario);
    }

    @Test
    void quandoCalcularDecimoTerceiroDeveriaRetornarValorCalculado() {
        CalculadoraSalario calculadoraSalario = new CalculadoraSalario();
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M");

        double decimoTerceiro = calculadoraSalario.calcularDecimoTerceiro(joao.getSalario(), 12);

        Assertions.assertEquals(20000.0, decimoTerceiro);
    }

}
