package hogwarts.api.domain.funcionario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroFuncionario dados, UriComponentsBuilder uriBuilder){
        var funcionario = new Funcionario(dados);
        repository.save(funcionario);

        var uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoFuncionario(funcionario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemFuncionario>> listar(@PageableDefault(size = 2, sort = {"bruxo"}) Pageable paginacao){
        var page =  repository.findAll(paginacao).map(DadosListagemFuncionario::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoFuncionario dados){
        var funcionario = repository.getReferenceById(dados.id());
        funcionario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity pesquisar(@RequestBody Long id){
        var funcionario = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }
}
