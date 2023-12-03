package hogwarts.api.domain.aluno;

import hogwarts.api.domain.bruxo.DadosBruxo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAluno(

        @NotNull
        @Valid
        DadosBruxo bruxo,
        @NotNull
        Casa casa,
        @NotBlank
        String mascote,
        @NotNull
        Status status,
        @NotNull
        Integer ano
) {
}
