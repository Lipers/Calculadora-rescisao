package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class INSSDescontoTest {

    @Test
    void quandoCalcularDescontoINSSSobreSaldoSalarioDeveriaRetornarValorCalculado() {

        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataFimContratoAntigo = LocalDate.of(2019, Month.DECEMBER, 31);
//        double baseSalario = joao.getSalario() /30 * //diasTrabalhadosNoMes;
    }


}
