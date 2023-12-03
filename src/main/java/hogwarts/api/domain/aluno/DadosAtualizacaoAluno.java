package hogwarts.api.domain.aluno;

import hogwarts.api.domain.bruxo.DadosBruxo;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(
        @NotNull
        Long id,
        DadosBruxo bruxo,
        String mascote,
        Status status,
        Integer ano) {
}
