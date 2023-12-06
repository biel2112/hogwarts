package hogwarts.api.domain.aula;

import java.time.LocalDateTime;

public record DadosDetalhamentoAula(Long id , Long idFuncionario, Long idAluno, LocalDateTime data) {
    public DadosDetalhamentoAula(Aula aula) {
        this(aula.getId(), aula.getFuncionario().getId(), aula.getAluno().getId(), aula.getData());
    }
}
