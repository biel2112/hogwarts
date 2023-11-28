package hogwarts.api.domain.bruxo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosBruxo(
        @NotBlank
        String nome,
        @NotBlank
        String sobrenome,
        @NotNull
        String varinha,
        @NotNull
        String patrono
) {
}
