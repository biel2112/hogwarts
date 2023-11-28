package hogwarts.api.domain.aluno;

import hogwarts.api.domain.bruxo.Bruxo;
import hogwarts.api.domain.endereco.Endereco;

public record DadosDetalhamentoAluno(Long id, Casa casa, Status status, Integer ano, String mascote, Bruxo bruxo, Endereco endereco) {
    
    public DadosDetalhamentoAluno(Aluno aluno){
        this(aluno.getId(), aluno.getCasa(), aluno.getStatus(), aluno.getAno(), aluno.getMascote(), aluno.getBruxo(), aluno.getEndereco());
    }
    
}
