package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.repository.FuncionarioRespository;
import com.evolui.TDD_Rest_API.service.FuncionarioService;
import com.evolui.TDD_Rest_API.service.FuncionarioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class FuncionarioServiceImplTest {

    @Test
    void quandoSalvarFuncionarioDeveriaSalvar() {
        FuncionarioRespository funcionarioRespository = mock(FuncionarioRespository.class);
        Funcionario funcionario = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M");
        when(funcionarioRespository.save(same(funcionario))).thenReturn(funcionario);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRespository);

        Funcionario funcionarioSalvado = funcionarioService.salvar(funcionario);

        Assertions.assertEquals(funcionario, funcionarioSalvado);
    }

    @Test
    void quandoDeletarFuncionarioDeveriaDeletarRegistro() {
        FuncionarioRespository funcionarioRespository = mock(FuncionarioRespository.class);
        when(funcionarioRespository.findById(1L)).thenReturn(Optional.of(new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M")));

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRespository);

        funcionarioService.delete(1L);

        verify(funcionarioRespository).deleteById(1L);
    }
}
