package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.Util.CalculadoraAvisoPrevioIndenizadoUtil;
import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.service.CalculadoraDecimoTerceiro;
import com.evolui.TDD_Rest_API.service.CalculadoraFGTS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class CalculadoraFGTSTest {

    @Test
    void quandoCalcularFGTSDeveriaRetornarValorCalculado() {
        CalculadoraFGTS calculadoraFGTS = new CalculadoraFGTS();
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 1500.0, "M");
        LocalDate dataInicioValorFixo = LocalDate.of(2019, Month.JANUARY, 15);
        LocalDate dataFinalValorFixo = LocalDate.of(2019, Month.FEBRUARY, 15);

        double saldoFGTS = calculadoraFGTS.calcularFGTS(joao.getSalario(), dataInicioValorFixo, dataFinalValorFixo);

        Assertions.assertEquals(1440, saldoFGTS);
    }

    @Test
    void quandoCalcularFGTSAvisoPrevioIndenizadoDeveriaRetornarValorCalculado() {
        CalculadoraFGTS calculadoraFGTS = new CalculadoraFGTS();
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);

        double valorIndenizado = CalculadoraAvisoPrevioIndenizadoUtil.calcular(joao.getSalario(), dataInicioContrato, dataFimContrato);

        double saldoFGTS = calculadoraFGTS.calcularFGTSAvisoIndenizadoOuDecimoTerceiroProporcional(valorIndenizado);

        Assertions.assertEquals(220, saldoFGTS);
    }

    @Test
    void quandoCalcularDecimoTerceiroFGTSProporcionalDeveriaRetornarValorCalculado() {
        CalculadoraFGTS calculadoraFGTS = new CalculadoraFGTS();
        CalculadoraDecimoTerceiro calculadoraDecimoTerceiro = new CalculadoraDecimoTerceiro();
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataInicioContrato = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);

        double decimoTerceiroProporcional = calculadoraDecimoTerceiro.calcularDecimoTerceiro(joao.getSalario(), dataInicioContrato, dataFimContrato);

        double resultado = calculadoraFGTS.calcularFGTSAvisoIndenizadoOuDecimoTerceiroProporcional(decimoTerceiroProporcional);

        Assertions.assertEquals(83.33, resultado);
    }

    @Test
    void quandoCalcularMultaFGTSDeveriaRetornarValorCalculado() {
        CalculadoraFGTS calculadoraFGTS = new CalculadoraFGTS();
        CalculadoraDecimoTerceiro calculadoraDecimoTerceiro = new CalculadoraDecimoTerceiro();
        Funcionario joaoSalarioAntigo = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 1500.0, "M");
        LocalDate dataInicioContratoAntigo = LocalDate.of(2019, Month.JANUARY, 01);
        LocalDate dataFimContratoAntigo = LocalDate.of(2019, Month.DECEMBER, 31);


        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 2500.0, "M");
        LocalDate dataInicioContrato = LocalDate.of(2020, Month.JANUARY, 01);
        LocalDate dataFimContrato = LocalDate.of(2020, Month.MAY, 18);

        double FGTSAntigo = calculadoraFGTS.calcularFGTS(joao.getSalario(), dataInicioContrato, dataFimContrato);
        double FGTSNovo = calculadoraFGTS.calcularFGTS(joaoSalarioAntigo.getSalario(), dataInicioContratoAntigo, dataFimContratoAntigo);

        double avisoPrevioIndenizado = CalculadoraAvisoPrevioIndenizadoUtil.calcular(joao.getSalario()
                , dataInicioContratoAntigo, dataFimContrato);

        double decimoTerceiroProporcional = calculadoraDecimoTerceiro.calcularDecimoTerceiro(joao.getSalario(), dataInicioContrato, dataFimContrato);

        double FGTSdecimoTerceiroProporcional = calculadoraFGTS.calcularFGTSAvisoIndenizadoOuDecimoTerceiroProporcional(decimoTerceiroProporcional);

        double FGTSAvisoPrevioIndenizado = calculadoraFGTS.calcularFGTSAvisoIndenizadoOuDecimoTerceiroProporcional(avisoPrevioIndenizado);

        double somaValores = FGTSAntigo + FGTSNovo  + FGTSdecimoTerceiroProporcional + FGTSAvisoPrevioIndenizado;

        double resultado = calculadoraFGTS.calculaMultaFGTS(somaValores);

        Assertions.assertEquals(1065.33, resultado);
    }
}
