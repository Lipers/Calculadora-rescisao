package com.evolui.TDD_Rest_API.service;

import com.evolui.TDD_Rest_API.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    Funcionario salvar(Funcionario funcionario);

    void delete(long id);

    List<Funcionario> visualizar();
}
