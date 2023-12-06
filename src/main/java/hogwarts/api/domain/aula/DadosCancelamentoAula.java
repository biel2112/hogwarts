package hogwarts.api.domain.aula;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoAula(
        @NotNull
        Long idAula,

        @NotNull
        MotivoCancelamento motivo


) {
}
