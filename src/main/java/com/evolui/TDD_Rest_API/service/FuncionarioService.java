package com.evolui.TDD_Rest_API.service;

import com.evolui.TDD_Rest_API.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    Funcionario salvar(Funcionario funcionario);

    void deletePorId(long id);

    List<Funcionario> consultar();

    Optional<Funcionario> consultarPorID(Long id);

    void deletarTodos();

    Funcionario atualizar(Funcionario funcionario);
}
