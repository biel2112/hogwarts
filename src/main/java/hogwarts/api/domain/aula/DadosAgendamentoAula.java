package hogwarts.api.domain.aula;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoAula(
        Long idFuncionario,

        @NotNull
        Long idAluno,

        @NotNull
        @Future LocalDateTime data
){}


