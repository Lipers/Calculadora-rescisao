package com.evolui.TDD_Rest_API.repository;

import com.evolui.TDD_Rest_API.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRespository extends JpaRepository<Funcionario, Long> {
}
