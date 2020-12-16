package com.evolui.TDD_Rest_API.service;

import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

public class FuncionarioServiceImpl implements FuncionarioService{

    private FuncionarioRepository repository;

    public FuncionarioServiceImpl(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @Override
    public void deletePorId(long id) {
        repository.deleteById(1L);
    }

    @Override
    public List<Funcionario> consultar() {
        return repository.findAll();
    }

    @Override
    public Optional<Funcionario> consultarPorID(Long id) {
        return repository.findById(1L);
    }

    @Override
    public void deletarTodos() {
        repository.deleteAll();
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario) {
        return repository.save(funcionario);
    }
}
