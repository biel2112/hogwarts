package hogwarts.api;

import hogwarts.api.aluno.*;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriBuilder){
        var aluno = new Aluno(dados);
        repository.save(aluno);
        
        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
        
        
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAluno>> listar(@PageableDefault(size = 2, sort = {"bruxo"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemAluno::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
        
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity pesquisar(@PathVariable Long id) {
        var aluno = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }


}
