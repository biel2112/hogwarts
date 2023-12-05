package hogwarts.api.domain.aula;

import java.time.LocalDateTime;

public record DadosDetalhamentoAula(Long id , Long idFuncionario, Long idAluno, LocalDateTime data) {
}
