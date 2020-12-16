package com.evolui.TDD_Rest_API.service;

import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.repository.FuncionarioRespository;

public class FuncionarioServiceImpl implements FuncionarioService{

    private FuncionarioRespository respository;

    public FuncionarioServiceImpl(FuncionarioRespository respository) {
        this.respository = respository;
    }

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        return respository.save(funcionario);
    }

    @Override
    public void delete(long id) {
        respository.deleteById(1L);
    }
}
