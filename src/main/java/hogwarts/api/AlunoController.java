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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados){
        repository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<DadosListagemAluno> listar(@PageableDefault(size = 2, sort = {"bruxo"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemAluno::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/{alunoId}")
    public ResponseEntity<Aluno> encontrarPorId(@PathVariable Long alunoId, HttpServletResponse response) {
        Optional<Aluno> aluno = repository.findById(alunoId);

        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get());
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return ResponseEntity.notFound().build();
        }
    }


}
