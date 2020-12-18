package com.evolui.TDD_Rest_API.model;

import com.evolui.TDD_Rest_API.enums.Cargo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private Cargo cargo;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "sexo")
    private String sexo;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, Cargo cargo, Double salario, String sexo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Double.compare(that.salario, salario) == 0 && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && cargo == that.cargo && Objects.equals(sexo, that.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cargo, salario, sexo);
    }

    public long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Double getSalario() {
        return this.salario;
    }

    public String getSexo() {
        return this.sexo;
    }
}
