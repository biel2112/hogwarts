package hogwarts.api.aluno;

import hogwarts.api.bruxo.DadosBruxo;
import hogwarts.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAluno(

        @NotNull
        @Valid
        DadosBruxo bruxo,
        @NotNull
        Casa casa,
        @NotNull
        @Valid
        DadosEndereco endereco,
        @NotBlank
        String mascote,
        @NotNull
        Status status,
        @NotNull
        Integer ano
) {
}
