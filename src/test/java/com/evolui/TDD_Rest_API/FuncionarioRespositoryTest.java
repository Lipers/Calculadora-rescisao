package com.evolui.TDD_Rest_API;

import com.evolui.TDD_Rest_API.enums.Cargo;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.repository.FuncionarioRespository;
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
public class FuncionarioRespositoryTest {

    @Autowired
    private FuncionarioRespository funcionarioRespository;

    @Test
    void quandoSalvarDeveriaRetornarFuncionarioSalvo() {
        Funcionario funcionario = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000, "M");
        funcionarioRespository.save(funcionario);

        Optional<Funcionario> funcionarioSalvo = funcionarioRespository.findById(1L);

        Assertions.assertTrue(funcionarioSalvo.isPresent());
        Assertions.assertEquals(funcionario, funcionarioSalvo.get());
    }

    @Test
    void quandoAtualizarDeveriaRetornarFuncionarioAtualizado() {
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000, "M");
        Funcionario felipe = new Funcionario(1L, "Felipe", Cargo.DESENVOLVEDOR, 20500, "M");
        funcionarioRespository.save(joao);
        funcionarioRespository.save(felipe);

        Optional<Funcionario> funcionarioSalvo = funcionarioRespository.findById(1L);

        Assertions.assertEquals(felipe, funcionarioSalvo.get());
    }

    @Test
    void quandoConsultarTodosDeveriaRetornarListaFuncionario() {
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000, "M");
        Funcionario felipe = new Funcionario(2L, "Felipe", Cargo.DESENVOLVEDOR, 20500, "M");
        funcionarioRespository.saveAll(Arrays.asList(joao, felipe));

        List<Funcionario> funcionarios = funcionarioRespository.findAll();

        Assertions.assertEquals(2, funcionarios.size());
    }

    @Test
    void quandoConsultarPorIdDeveriaRetornarFuncionario() {
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000, "M");
        funcionarioRespository.save(joao);

        Optional<Funcionario> funcionario = funcionarioRespository.findById(1L);

        Assertions.assertEquals(joao, funcionario.get());
    }

    @Test
    void quandoDeletarPorIdDeveriaDeletar() {
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000, "M");
        funcionarioRespository.save(joao);

        funcionarioRespository.delete(joao); //TODO: Perguntar pq deleteById nao funcionou
        Optional<Funcionario> funcionario = funcionarioRespository.findById(1L);

        Assertions.assertFalse(funcionario.isPresent());
    }

    @Test
    void quandoDeletarTodosDeveriaDeletarTodos() {
        Funcionario joao = new Funcionario(1L, "João", Cargo.DESENVOLVEDOR, 10000, "M");
        Funcionario felipe = new Funcionario(2L, "Felipe", Cargo.DESENVOLVEDOR, 20500, "M");
        funcionarioRespository.saveAll(Arrays.asList(joao, felipe));

        funcionarioRespository.deleteAll();
        List<Funcionario> funcionarios = funcionarioRespository.findAll();

        Assertions.assertTrue(funcionarios.isEmpty());
    }
}
