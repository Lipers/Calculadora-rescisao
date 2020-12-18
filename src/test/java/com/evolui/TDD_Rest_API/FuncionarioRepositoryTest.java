package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.repository.FuncionarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
public class FuncionarioRepositoryTest {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Test
    void quandoSalvarDeveriaRetornarFuncionarioSalvo() {
        Funcionario funcionario = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000.0, "M");
        funcionarioRepository.save(funcionario);

        Optional<Funcionario> funcionarioSalvo = funcionarioRepository.findById(1L);

        Assertions.assertTrue(funcionarioSalvo.isPresent());
        Assertions.assertEquals(funcionario, funcionarioSalvo.get());
    }

    @Test
    void quandoAtualizarDeveriaRetornarFuncionarioAtualizado() {
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000.0, "M");
        Funcionario felipe = new Funcionario(1L, "Felipe", Cargo.DESENVOLVEDOR, 20500.0, "M");
        funcionarioRepository.save(joao);
        funcionarioRepository.save(felipe);

        Optional<Funcionario> funcionarioSalvo = funcionarioRepository.findById(1L);

        Assertions.assertEquals(felipe, funcionarioSalvo.get());
    }

    @Test
    void quandoConsultarTodosDeveriaRetornarListaFuncionario() {
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000.0, "M");
        Funcionario felipe = new Funcionario(2L, "Felipe", Cargo.DESENVOLVEDOR, 20500.0, "M");
        funcionarioRepository.saveAll(Arrays.asList(joao, felipe));

        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        Assertions.assertEquals(2, funcionarios.size());
    }

    @Test
    void quandoConsultarPorIdDeveriaRetornarFuncionario() {
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000.0, "M");
        funcionarioRepository.save(joao);

        Optional<Funcionario> funcionario = funcionarioRepository.findById(1L);

        Assertions.assertEquals(joao, funcionario.get());
    }

    @Test
    void quandoDeletarPorIdDeveriaDeletar() {
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000.0, "M");
        funcionarioRepository.save(joao);

        funcionarioRepository.delete(joao); //TODO: Perguntar pq deleteById nao funcionou
        Optional<Funcionario> funcionario = funcionarioRepository.findById(1L);

        Assertions.assertFalse(funcionario.isPresent());
    }

    @Test
    void quandoDeletarTodosDeveriaDeletarTodos() {
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000.0, "M");
        Funcionario felipe = new Funcionario(2L, "Felipe", Cargo.DESENVOLVEDOR, 20500.0, "M");
        funcionarioRepository.saveAll(Arrays.asList(joao, felipe));

        funcionarioRepository.deleteAll();
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        Assertions.assertTrue(funcionarios.isEmpty());
    }
}
