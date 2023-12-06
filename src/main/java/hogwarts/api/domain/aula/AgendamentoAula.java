package hogwarts.api.domain.aula;

import hogwarts.api.domain.ValidacaoException;
import hogwarts.api.domain.aluno.AlunoRepository;
import hogwarts.api.domain.funcionario.Funcionario;
import hogwarts.api.domain.funcionario.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoAula {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public void agendar(DadosAgendamentoAula dados){

        if(!alunoRepository.existsById(dados.idAluno())){
            throw new ValidacaoException("ID do aluno informado não existe!");
        }

        if(dados.idFuncionario() != null && !funcionarioRepository.existsById(dados.idFuncionario())){
            throw new ValidacaoException("ID do funcionario informado não existe!");
        }

        var funcionario = escolherFuncionario(dados);
        var aluno = alunoRepository.getReferenceById(dados.idAluno());
        var aula = new Aula(null, funcionario, aluno, dados.data(), null);

        aulaRepository.save(aula);
    }

    public void cancelar(DadosCancelamentoAula dados) {
        if (!aulaRepository.existsById(dados.idAula())) {
            throw new ValidacaoException("ID da aula informado não existe!");
        }
        var aula = aulaRepository.getReferenceById(dados.idAula());
        aula.cancelar(dados.motivo());
    }

    private Funcionario escolherFuncionario(DadosAgendamentoAula dados){
        if(dados.idFuncionario() != null){
            return funcionarioRepository.getReferenceById(dados.idFuncionario());
        }

        return null;
    }
}
