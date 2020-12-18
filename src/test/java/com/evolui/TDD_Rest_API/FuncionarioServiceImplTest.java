package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.repository.FuncionarioRepository;
import com.evolui.TDD_Rest_API.service.FuncionarioService;
import com.evolui.TDD_Rest_API.service.FuncionarioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class FuncionarioServiceImplTest {

    @Test
    void quandoSalvarFuncionarioDeveriaSalvar() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        Funcionario funcionario = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M");
        when(funcionarioRepository.save(same(funcionario))).thenReturn(funcionario);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        Funcionario funcionarioSalvado = funcionarioService.salvar(funcionario);

        Assertions.assertEquals(funcionario, funcionarioSalvado);
    }

    @Test
    void quandoDeletarPorIdFuncionarioDeveriaDeletarRegistro() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M")));

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        funcionarioService.deletePorId(1L);

        verify(funcionarioRepository).deleteById(1L);
    }

    @Test
    void quandoConsultarFuncionarioDeveriaRetornarListaDeFuncionario() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        when(funcionarioRepository.findAll()).thenReturn(Arrays.asList((new Funcionario())));

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);
        List<Funcionario> listaDeFuncionario = funcionarioService.consultar();

        Assertions.assertFalse(listaDeFuncionario.isEmpty());
        Assertions.assertEquals(1, listaDeFuncionario.size());
    }

    @Test
    void quandoConsultarFuncionarioPorIdDeveriaRetornarFuncionarioEsperado() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 100.0, "M")));

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);
        Optional<Funcionario> funcionario = funcionarioService.consultarPorID(1L);

        Assertions.assertEquals(1L, funcionario.get().getId());
        Assertions.assertEquals("João", funcionario.get().getNome());
        Assertions.assertEquals(Cargo.DESENVOLVEDOR, funcionario.get().getCargo());
        Assertions.assertEquals(100.0, funcionario.get().getSalario());
        Assertions.assertEquals("M", funcionario.get().getSexo());
    }

    @Test
    void quandoChamarDeletarDeveriaDeletarTodosOsFuncionarios() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        funcionarioService.deletarTodos();

        verify(funcionarioRepository).deleteAll();
    }

    @Test
    void quandoChamarAtualizarDeveriaAtualizar() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M");
        Funcionario candido = new Funcionario(1L, "Candido", Cargo.ANALISTA, 200000.0, "M");
        when(funcionarioRepository.save(same(joao))).thenReturn(joao);
        when(funcionarioRepository.save(same(candido))).thenReturn(candido);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        funcionarioService.atualizar(joao);
        Funcionario funcionario = funcionarioService.atualizar(candido);

        Assertions.assertEquals(1L, funcionario.getId());
        Assertions.assertEquals("Candido", funcionario.getNome());
        Assertions.assertEquals(Cargo.ANALISTA, funcionario.getCargo());
        Assertions.assertEquals(200000.0, funcionario.getSalario());
        Assertions.assertEquals("M", funcionario.getSexo());
    }

    @Test
    void quandoChamarAtualizarDeveriaValidarSeNomeEstaPreenchido() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M");
        Funcionario candido = new Funcionario(1L, "", Cargo.DESENVOLVEDOR, 20000.0, "M");
        when(funcionarioRepository.save(same(joao))).thenReturn(joao);
        when(funcionarioRepository.save(same(candido))).thenReturn(candido);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        funcionarioService.salvar(joao);

        try {
            funcionarioService.atualizar(candido);
            fail();
        } catch (Exception e) {
            assertEquals("Nome do funcionário precisa estar preenchido", e.getMessage());
        }
    }


    @Test
    void quandoChamarAtualizarDeveriaValidarSeSalarioEstaPreenchido() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M");
        Funcionario candido = new Funcionario(1L, "Candido", Cargo.DESENVOLVEDOR, null, "M");
        when(funcionarioRepository.save(same(joao))).thenReturn(joao);
        when(funcionarioRepository.save(same(candido))).thenReturn(candido);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        funcionarioService.salvar(joao);

        try {
            funcionarioService.atualizar(candido);
            fail();
        } catch (Exception e) {
            assertEquals("Salário do funcionário precisa estar preenchido", e.getMessage());
        }
    }


    @Test
    void quandoChamarAtualizarDeveriaValidarSeCargoEstaPreenchido() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M");
        Funcionario candido = new Funcionario(1L, "Candido", null, 20000.0, "M");

        when(funcionarioRepository.save(same(joao))).thenReturn(joao);
        when(funcionarioRepository.save(same(candido))).thenReturn(candido);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        funcionarioService.salvar(joao);

        try {
            funcionarioService.atualizar(candido);
            fail();
        } catch (Exception e) {
            assertEquals("Cargo do funcionário precisa estar preenchido", e.getMessage());
        }
    }



    @Test
    void quandoChamarAtualizarDeveriaValidarSeSexoEstaPreenchido() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "M");
        Funcionario candido = new Funcionario(1L, "Candido", Cargo.DESENVOLVEDOR, 20000.0, "");

        when(funcionarioRepository.save(same(joao))).thenReturn(joao);
        when(funcionarioRepository.save(same(candido))).thenReturn(candido);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        funcionarioService.salvar(joao);

        try {
            funcionarioService.atualizar(candido);
            fail();
        } catch (Exception e) {
            assertEquals("Sexo do funcionário precisa estar preenchido", e.getMessage());
        }
    }


    @Test
    void quandoChamarSalvarDeveriaValidarSeNomeEstaPreenchido() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        Funcionario joao = new Funcionario(1L, "", Cargo.DESENVOLVEDOR, 20000.0, "M");
        when(funcionarioRepository.save(same(joao))).thenReturn(joao);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        try {
            funcionarioService.salvar(joao);
            fail();
        } catch (Exception e) {
            assertEquals("Nome do funcionário precisa estar preenchido", e.getMessage());
        }
    }

    @Test
    void quandoChamarSalvarDeveriaValidarSeSalarioEstaPreenchido() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, null, "M");
        when(funcionarioRepository.save(same(joao))).thenReturn(joao);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        try {
            funcionarioService.salvar(joao);
            fail();
        } catch (Exception e) {
            assertEquals("Salário do funcionário precisa estar preenchido", e.getMessage());
        }
    }

    @Test
    void quandoChamarSalvarDeveriaValidarSeCargoEstaPreenchido() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        Funcionario joao = new Funcionario(1L, "João", null, 20000.0, "M");
        when(funcionarioRepository.save(same(joao))).thenReturn(joao);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        try {
            funcionarioService.salvar(joao);
            fail();
        } catch (Exception e) {
            assertEquals("Cargo do funcionário precisa estar preenchido", e.getMessage());
        }
    }

    @Test
    void quandoChamarSalvarDeveriaValidarSeSexoEstaPreenchido() {
        FuncionarioRepository funcionarioRepository = mock(FuncionarioRepository.class);
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 20000.0, "");
        when(funcionarioRepository.save(same(joao))).thenReturn(joao);

        FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        try {
            funcionarioService.salvar(joao);
            fail();
        } catch (Exception e) {
            assertEquals("Sexo do funcionário precisa estar preenchido", e.getMessage());
        }
    }
}
