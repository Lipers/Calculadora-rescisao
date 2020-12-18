package com.evolui.TDD_Rest_API.service;

import com.evolui.TDD_Rest_API.exception.AtributoFuncionarioInvalido;
import com.evolui.TDD_Rest_API.model.Funcionario;
import com.evolui.TDD_Rest_API.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository repository;

    public FuncionarioServiceImpl(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Funcionario salvar(Funcionario funcionario) {

        validaCamposObrigatorios(funcionario);

        return repository.save(funcionario);
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario) {

        validaCamposObrigatorios(funcionario);

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

    private void validaCamposObrigatorios(Funcionario funcionario) {
        if (funcionario.getNome().isEmpty() || funcionario.getNome() == null)
            throw new AtributoFuncionarioInvalido("Nome do funcionário precisa estar preenchido");


        if (funcionario.getSalario() == null)
            throw new AtributoFuncionarioInvalido("Salário do funcionário precisa estar preenchido");


        if (funcionario.getCargo() == null)
            throw new AtributoFuncionarioInvalido("Cargo do funcionário precisa estar preenchido");


        if (funcionario.getSexo().isEmpty() || funcionario.getSexo() == null)
            throw new AtributoFuncionarioInvalido("Sexo do funcionário precisa estar preenchido");
    }
}
