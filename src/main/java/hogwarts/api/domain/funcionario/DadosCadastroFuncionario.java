package hogwarts.api.domain.funcionario;

import hogwarts.api.domain.bruxo.DadosBruxo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFuncionario(

        @NotNull
        @Valid
        DadosBruxo bruxo,
        @NotNull
        String transformacao,
        @NotNull
        String materia,
        @NotNull
        Cargo cargo
) {
}
