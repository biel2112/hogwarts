package hogwarts.api.domain.aluno;

import hogwarts.api.domain.bruxo.Bruxo;

public record DadosDetalhamentoAluno(Long id, Casa casa, Status status, Integer ano, String mascote, Bruxo bruxo) {
    
    public DadosDetalhamentoAluno(Aluno aluno){
        this(aluno.getId(), aluno.getCasa(), aluno.getStatus(), aluno.getAno(), aluno.getMascote(), aluno.getBruxo());
    }
    
}
