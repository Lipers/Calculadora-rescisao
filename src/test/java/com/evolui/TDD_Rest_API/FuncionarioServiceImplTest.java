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

}
