package hogwarts.api.domain.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno cadastrar(DadosCadastroAluno dados){
        var aluno = new Aluno(dados);
        return alunoRepository.save(aluno);
    }

    public Page<DadosListagemAluno> listar(Pageable paginacao){
        return alunoRepository.findAll(paginacao).map(DadosListagemAluno::new);
    }

    public Aluno atualizar(DadosAtualizacaoAluno dados){
        var aluno = alunoRepository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
        return alunoRepository.save(aluno);
    }

    public void excluir(Long id){
        alunoRepository.deleteById(id);
    }

    public Aluno pesquisar(Long id){
        return alunoRepository.getReferenceById(id);
    }

}
