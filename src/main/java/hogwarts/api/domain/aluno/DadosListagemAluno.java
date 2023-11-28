package hogwarts.api.domain.aluno;

import hogwarts.api.domain.bruxo.Bruxo;

public record DadosListagemAluno(Long id, Bruxo bruxo, Casa casa, Integer ano, Status status) {

    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(), aluno.getBruxo(), aluno.getCasa(), aluno.getAno(), aluno.getStatus());
    }
}
