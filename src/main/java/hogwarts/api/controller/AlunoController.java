package hogwarts.api.controller;

import hogwarts.api.domain.aluno.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@RequestMapping("/alunos")
@SecurityRequirement(name = "bearer-key")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriBuilder){
        var aluno = service.cadastrar(dados);
        
        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
        
        
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAluno>> listar(@PageableDefault(size = 2, sort = {"bruxo"}) Pageable paginacao){
        var page = service.listar(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados){
        var aluno = service.atualizar(dados);
        
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){

        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity pesquisar(@PathVariable Long id) {
        var aluno = service.pesquisar(id);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @Transactional
    @PutMapping("/{id}/expulsar")
    public ResponseEntity<String> expulsarAluno(@PathVariable Long id) {
        if(service.alunoExiste(id)){
            service.expulsarAluno(id);
            return ResponseEntity.ok("Aluno expulso");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


}
