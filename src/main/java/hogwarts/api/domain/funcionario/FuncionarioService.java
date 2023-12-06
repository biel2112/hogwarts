package hogwarts.api.domain.funcionario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario cadastrar(DadosCadastroFuncionario dados){
        var funcionario = new Funcionario(dados);
        return repository.save(funcionario);

    }

    public Page<DadosListagemFuncionario> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemFuncionario::new);
    }

    public Funcionario atualizar(DadosAtualizacaoFuncionario dados){
        var funcionario = repository.getReferenceById(dados.id());
        funcionario.atualizarInformacoes(dados);
        return repository.save(funcionario);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public Funcionario pesquisar(Long id) {
        return repository.getReferenceById(id);
    }

}
